package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String acesso(){
        return "/login/login";
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
        } //...

        return retorno;
    }
}
