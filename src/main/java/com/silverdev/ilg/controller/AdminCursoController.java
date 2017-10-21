package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Curso;
import com.silverdev.ilg.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/register")
    public String telaRegistroCurso(Model model){
        model.addAttribute("curso", new Curso());

        return "/admin/registerCurso";
    }

    @PostMapping("/register")
    public String registroCurso(@Valid Curso curso, RedirectAttributes ra){
        cursoRepository.save(curso);

        return "redirect:/admCursos";
    }

    @GetMapping("/edit/{id}")
    public String telaEditaCurso(@PathVariable("id") Integer id, Model model){
        //model.addAttribute("usuario", new Usuario());
        model.addAttribute("curso", cursoRepository.getOne(id));

        return "/admin/editCurso";
    }

    @PostMapping("/edit/{id}")
    public String editaCurso(@PathVariable("id") Integer id, @Valid Curso curso, Model model){
        cursoRepository.saveAndFlush(curso);

        return "redirect:/admCursos";
    }


    @GetMapping("/delete/{id}")
    public String deletaCurso(@PathVariable("id") Integer id){
        cursoRepository.delete(id);

        return "redirect:/admCursos";
    }
}
