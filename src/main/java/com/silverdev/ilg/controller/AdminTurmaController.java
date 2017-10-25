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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/admin/admTurmas")
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
        model.addAttribute("turmas", turmaRepository.findByAtivo(true));
        model.addAttribute("cursos", cursoRepository.findAll());

        return "/admin/turma";

    }

    @GetMapping("/register")
    public String telaRegistroTurma(Model model){
        model.addAttribute("professores", usuarioRepository.findAllByAtivoAndAcesso(true,Role.ROLE_PROFESSOR));
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("turma", new Turma());

        return "admin/registerTurma";
    }

    @PostMapping("/register")
    public String registroTurma(@Valid Turma turma, RedirectAttributes ra){
        turma.setData_criacao(getMonthAndYear());
        turmaRepository.save(turma);
        ra.addFlashAttribute("sucesso", "Turma registrada com sucesso!");

        return "redirect:/admin/admTurmas";
    }

    @GetMapping("/edit/{id}")
    public String telaEditaTurma(@PathVariable("id") Integer id, Model model){
        model.addAttribute("professores", usuarioRepository.findAllByAtivoAndAcesso(true, Role.ROLE_PROFESSOR));
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("turma", turmaRepository.findOne(id));

        return "admin/editTurma";
    }

    @PostMapping("/edit/{id}")
    public String editaTurma(@PathVariable("id") Integer id, @Valid Turma turma, RedirectAttributes ra){
        turma.setData_criacao(getMonthAndYear());
        turmaRepository.saveAndFlush(turma);
        ra.addFlashAttribute("editado", "Turma atualizada com sucesso!");

        return "redirect:/admin/admTurmas";
    }

    @GetMapping("/delete/{id}")
    public String deletaTurma(@PathVariable("id") Integer id, RedirectAttributes ra){
        Turma turma = turmaRepository.getOne(id);
        turma.setAtivo(false);
        turmaRepository.saveAndFlush(turma);
        ra.addFlashAttribute("excluido", "Turma excluída com sucesso!");

        return "redirect:/admin/admTurmas";
    }

    private String getMonthAndYear(){
        Calendar cal = Calendar.getInstance();
        int year, month;

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) +1;

        return month + "/" + year;
    }
}
