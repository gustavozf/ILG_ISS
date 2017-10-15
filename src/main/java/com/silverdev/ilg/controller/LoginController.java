package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.enums.Acesso;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/redirectTipoUsuario")
    public String redirecionaUsuario(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String acesso = auth.getAuthorities().toString();
        acesso = acesso.replace("[", "");
        acesso = acesso.replace("]","");

        String retorno = "";
        if(acesso.equals(Acesso.A.toString())){
            retorno = "redirect:/aluno";
        } else if (acesso.equals(Acesso.P.toString())){
            retorno = "redirect:/professor";
        } //...

        return retorno;
    }
}
