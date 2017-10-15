package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.CursoRepository;
import com.silverdev.ilg.repository.FuncionarioRepository;
import com.silverdev.ilg.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    public String abreTelaTurma(Model model){
        String retorno = "";

        return retorno;

    }

}
