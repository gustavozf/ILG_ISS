package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/habilitaInscricao")
public class AdminHabilitaController {

    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public AdminHabilitaController(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository = inscricaoRepository;
    }

    @GetMapping
    public String habila(Model model){

        List<Inscricao> inscricoes = inscricaoRepository.findAll();

        model.addAttribute("inscricao", inscricoes);

        return "/admin/habilitacao";
    }



}
