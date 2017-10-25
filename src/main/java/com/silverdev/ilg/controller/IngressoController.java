package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by narcizo on 19/10/17.
 */

@Controller
@RequestMapping("/ingresso")
public class IngressoController {
    private final UsuarioRepository usuarioRepository;

    public IngressoController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String registro(Model model){
        model.addAttribute("ingresso", usuarioRepository.findAll());
        return "/ingressante/register";
    }
    @GetMapping("/register")
    public String telaRegistroFuncionario(Model model){
        model.addAttribute("usuario", new Usuario());

        return "/ingressante/register";
    }
    @PostMapping("/register")
    public String registraFuncionario(@Valid Usuario usuario, RedirectAttributes ra) {
        String redirecionamento = "redirect:/";

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
            ra.addFlashAttribute("sucesso", "Ingressante registrado com sucesso!");
            usuario.setAtivo(true);
            usuario.setId( usuarioRepository.getOneByCpf(usuario.getCpf()).getId());
            usuarioRepository.saveAndFlush(usuario);
        }else if(condicao1 && condicao2){
            ra.addFlashAttribute("error_cpf", "Erro! CPF '"+usuario.getCpf() +"' já cadastrado!");
            redirecionamento = "redirect:/ingresso/register";
        } else if(condicao3) {
            ra.addFlashAttribute("error_user", "Erro! Username '"+usuario.getUsername() +"' já cadastrado!");
            redirecionamento = "redirect:/ingresso/register";
        } else {
            ra.addFlashAttribute("sucesso", "Funcionário '"+usuario.getNome() +" "+
                    usuario.getSobrenome() + "' registrado com sucesso!");
            usuarioRepository.save(usuario);
        }


        return redirecionamento;
    }


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
