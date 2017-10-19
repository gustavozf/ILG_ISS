package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admFuncionarios")
public class AdminFuncionarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AdminFuncionarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @InitBinder
    public void formataData(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //CRUDs em relacao ao funcionario!
    @GetMapping
    public String abreTelaFuncionarios(Model model){
        model.addAttribute("funcionarios", usuarioRepository.findAll());

        return "/admin/funcionario";
    }

    @GetMapping("/register")
    public String telaRegistroFuncionario(Model model){
        model.addAttribute("usuario", new Usuario());

        return "/admin/registerFuncionario";
    }

    @PostMapping("/register")
    public String registraFunciionario(@Valid Usuario usuario, BindingResult br, RedirectAttributes ra){
        usuario.setPassword(pe().encode(usuario.getPassword()));
        usuarioRepository.save(usuario);


        return "redirect:/admFuncionarios";
    }

    @GetMapping("/delete")
    public String deletaFuncionario(@PathVariable("id") Integer id){
        usuarioRepository.delete(id);

        return "redirect:/admFuncionarios";
    }


    @Bean
    public PasswordEncoder pe() {
        return new BCryptPasswordEncoder();
    }
}
