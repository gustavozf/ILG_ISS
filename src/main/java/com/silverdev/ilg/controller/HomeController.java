package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.enums.Role;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/index", "index.html"})
public class HomeController {

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
            retorno = "redirect:/admFuncionarios";
        } else if (acesso.equals(Role.ROLE_PROFESSOR.toString())){
            retorno = "redirect:/professor";
        } else if (acesso.equals(Role.ROLE_ALUNO.toString())){
            retorno = "redirect:/aluno";
        } else if (acesso.equals(Role.ROLE_INGRESSANTE.toString())){
            retorno = "redirect:/ingressante";
        }

        return retorno;
    }
}
