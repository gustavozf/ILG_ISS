package com.silverdev.ilg.controller;

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

    @Autowired
    public AdminTurmaController(TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
    }


    //CRUDs em relacao a turma!

    @GetMapping
    public String abreTelaTurmas(Model model){
        model.addAttribute("turmas", turmaRepository.findAll());

        return "/admin/turma";

    }

    @GetMapping("/delete/{id}")
    public String deletaTurma(@PathVariable("id") Integer id){
        turmaRepository.delete(id);

        return "redirect:/admin/turmas";
    }
}
