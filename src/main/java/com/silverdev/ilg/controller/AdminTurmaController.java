package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Curso;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.model.enums.Role;
import com.silverdev.ilg.repository.CursoRepository;
import com.silverdev.ilg.repository.TurmaRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admTurmas")
public class AdminTurmaController {
    private final TurmaRepository turmaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public AdminTurmaController(TurmaRepository turmaRepository,
                                UsuarioRepository usuarioRepository,
                                CursoRepository cursoRepository){
        this.turmaRepository = turmaRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }


    //CRUDs em relacao a turma!

    @GetMapping
    public String abreTelaTurmas(Model model){
        model.addAttribute("turmas", turmaRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll());

        return "/admin/turma";

    }

    @GetMapping("/register")
    public String telaRegistroTurma(Model model){
        model.addAttribute("professores", usuarioRepository.findAllByAcesso(Role.ROLE_PROFESSOR));
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("turma", new Turma());

        return "admin/registerTurma";
    }

    @GetMapping("/delete/{id}")
    public String deletaTurma(@PathVariable("id") Integer id){
        turmaRepository.delete(id);

        return "redirect:/admin/turmas";
    }
}
