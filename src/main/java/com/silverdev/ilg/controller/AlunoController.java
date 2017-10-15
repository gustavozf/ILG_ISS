package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public String abreTelaAluno(Model model){
        model.addAttribute("aluno", alunoRepository.findAll());

        return "/aluno/aluno";
    }
}
