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
@RequestMapping("/admCursos")
public class AdminCursoController {
    private final CursoRepository cursoRepository;

    @Autowired
    public AdminCursoController(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    //CRUDs em relacao ao curso!

    @GetMapping
    public String abreTelaCursos(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());

        return "/admin/curso";
    }

    @GetMapping("/delete/{id}")
    public String deletaCurso(@PathVariable("id") Integer id){
        cursoRepository.delete(id);

        return "redirect:/admCursos";
    }
}
