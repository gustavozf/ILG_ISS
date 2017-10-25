package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by narcizo on 23/10/17.
 */
@Controller
@RequestMapping("/ingressante")
public class IngressanteController {
    @GetMapping
    public String abreTelaIngressante(Model model){
            model.addAttribute("ingressante", new Usuario());
            return "/ingressante/ingressante";
    }
}
