package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/habilitaInscricao")
public class AdminHabilitaController {

    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public AdminHabilitaController(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository = inscricaoRepository;
    }

    @InitBinder
    public void formataData(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String habilacao(Model model){

        List<Inscricao> inscricoes = inscricaoRepository.findAll();

        model.addAttribute("inscricao", inscricoes);

        return "/admin/habilitacao";
    }

    @GetMapping("/register")
    public String registerInscricao(Model model){
        model.addAttribute("inscricao", new Inscricao());

        return "/admin/habilitacao/register";
    }



}
