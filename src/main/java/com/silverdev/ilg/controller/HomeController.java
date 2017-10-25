package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.enums.Role;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping({"/","/index", "index.html"})
public class HomeController {
    private UsuarioRepository usuarioRepository;

    public HomeController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String home(){
        return "index2";
    }

    @GetMapping("/redirectTipoUsuario")
    public String redirecionaUsuario(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String acesso = auth.getAuthorities().toString();
        acesso = acesso.replace("[", "");
        acesso = acesso.replace("]","");

        String retorno = "";
        if(acesso.equals(Role.ROLE_ADMIN.toString())){
            retorno = "redirect:/admin";
        } else if (acesso.equals(Role.ROLE_PROFESSOR.toString())){
            retorno = "redirect:/professor";
        } else if (acesso.equals(Role.ROLE_ALUNO.toString())){
            Integer id = usuarioRepository.findUsuarioByUsername(auth.getName()).getId();
            retorno = "redirect:/aluno/" + id;
        } else if (acesso.equals(Role.ROLE_INGRESSANTE.toString())){
            retorno = "redirect:/ingressante";
        } else if (acesso.equals(Role.ROLE_SECRETARIA.toString())){
            retorno = "redirect:/funcionario";
        }

        return retorno;
    }
}
