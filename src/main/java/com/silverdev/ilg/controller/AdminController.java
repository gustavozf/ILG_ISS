package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.CursoRepository;
import com.silverdev.ilg.repository.FuncionarioRepository;
import com.silverdev.ilg.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    private final TurmaRepository turmaRepository;
    private final CursoRepository cursoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public AdminController(TurmaRepository turmaRepository,
                           CursoRepository cursoRepository,
                           FuncionarioRepository funcionarioRepository
                           ){
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public String abreTelaAdmin(){
        return "/admin/index";
    }

    @GetMapping("/turmas")
    public String abreTelaTurmas(Model model){
        model.addAttribute("turmas", turmaRepository.findAll());

        return "/admin/turma";

    }

    @GetMapping("/cursos")
    public String abreTelaCursos(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());

        return "/admin/curso";
    }

    @GetMapping("/funcionarios")
    public String abreTelaFuncionarios(Model model){
        model.addAttribute("funcionarios", funcionarioRepository.findAll());

        return "/admin/funcionario";
    }

}
