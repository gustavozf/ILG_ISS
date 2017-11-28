package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.AlunoRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    private final UsuarioRepository usuarioRepository;
    private final AlunoRepository alunoRepository;


    @Autowired
    public ProfessorController(UsuarioRepository usuarioRepository, AlunoRepository alunoRepositoryRepository){
        this.usuarioRepository = usuarioRepository;
        this.alunoRepository = alunoRepositoryRepository;
    }

    @GetMapping
    public String telaFuncionario(){ return "/professor/index"; }
}
