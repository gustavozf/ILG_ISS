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
        model.addAttribute("funcionarios", usuarioRepository.findByAtivo(true));

        return "/admin/funcionario";
    }

    @GetMapping("/register")
    public String telaRegistroFuncionario(Model model){
        model.addAttribute("usuario", new Usuario());

        return "/admin/registerFuncionario";
    }

    @PostMapping("/register")
    public String registraFuncionario(@Valid Usuario usuario, RedirectAttributes ra) {
        String redirecionamento = "redirect:/admFuncionarios";

        //Checa se existe o CPF no BD
        boolean condicao1 = existeCpf(usuario.getCpf());
        //Checa se existe um mesmo usuario inativo
        boolean condicao2 = false;
        if (condicao1){
            condicao2 = usuarioRepository.getOneByCpf(usuario.getCpf()).getAtivo();
        }
        //Checa se existe o username
        boolean condicao3 = existeUsername(usuario.getUsername());

        usuario.setPassword(pe().encode(usuario.getPassword()));

        if(condicao1 && !condicao2){
            ra.addFlashAttribute("sucesso", "Funcionário registrado com sucesso!");
            usuario.setAtivo(true);
            usuario.setId( usuarioRepository.getOneByCpf(usuario.getCpf()).getId());
            usuarioRepository.saveAndFlush(usuario);
        }else if(condicao1 && condicao2){
            ra.addFlashAttribute("error_cpf", "Erro! CPF '"+usuario.getCpf() +"' já cadastrado!");
            redirecionamento = "redirect:/admFuncionarios/register";
        } else if(condicao3) {
            ra.addFlashAttribute("error_user", "Erro! Username '"+usuario.getUsername() +"' já cadastrado!");
            redirecionamento = "redirect:/admFuncionarios/register";
        } else {
            ra.addFlashAttribute("sucesso", "Funcionário '"+usuario.getNome() +" "+
                    usuario.getSobrenome() + "' registrado com sucesso!");
            usuarioRepository.save(usuario);
        }


        return redirecionamento;
    }

    @GetMapping("/edit/{id}")
    public String telaEditaFuncionario(@PathVariable("id") Integer id, Model model){
        model.addAttribute("funcionario", usuarioRepository.getOne(id));

        return "/admin/editFuncionario";
    }

    @PostMapping("/edit/{id}")
    public String editaFuncionario(@PathVariable("id") Integer id, @Valid Usuario usuario, RedirectAttributes ra){
        usuario.setPassword(pe().encode(usuario.getPassword()));
        usuarioRepository.saveAndFlush(usuario);
        ra.addFlashAttribute("editado", "Funcionario editado com sucesso!");

        return "redirect:/admFuncionarios";
    }

    @GetMapping("/delete/{id}")
    public String deletaFuncionario(@PathVariable("id") Integer id, RedirectAttributes ra){
        //usuarioRepository.delete(id);
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setAtivo(false);
        usuarioRepository.saveAndFlush(usuario);
        ra.addFlashAttribute("excluido", "Funcionario excluído com sucesso!");

        return "redirect:/admFuncionarios";
    }

    @GetMapping("/readMore/{id}")
    public String telaReadMore(@PathVariable("id") Integer id, Model model){
        model.addAttribute("funcionario", usuarioRepository.getOne(id));

        return "/admin/moreFuncionario";
    }

    @Bean
    public PasswordEncoder pe() {
        return new BCryptPasswordEncoder();
    }

    private boolean existeCpf(String cpf){
        return usuarioRepository.findByCpf(cpf).isPresent();
    }

    private boolean existeUsername(String username){
        return usuarioRepository.findByUsername(username).isPresent();
    }
}
