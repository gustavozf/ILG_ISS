package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.IngressanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionario")

public class FuncionarioController {
    private final IngressanteRepository ingressanteRepository;

    @Autowired
    public FuncionarioController(IngressanteRepository ingressanteRepository){ this.ingressanteRepository = ingressanteRepository;}

    //Cruds do funcionario

    @GetMapping
    public String abreTelaFuncionario(Model model){
        model .addAttribute("ingressantes", ingressanteRepository.findAll());

        return "/funcionario/ingressante";
    }
}
