package com.silverdev.ilg.controller;

import com.silverdev.ilg.repository.AlunoRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno/{id}")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository,
                           UsuarioRepository usuarioRepository){
        this.alunoRepository = alunoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String abreTelaAluno(@PathVariable("id") Integer id, Model model){
        model.addAttribute("aluno", usuarioRepository.getOne(id));

        return "/aluno/aluno";
    }

    @GetMapping("/notas/{id}")
    public String visuaNotas(@PathVariable("id") Integer id, Model model){
        String cpf = usuarioRepository.getOne(id).getCpf();

        model.addAttribute("notas", alunoRepository.findByCpf(cpf));
        model.addAttribute("aluno", usuarioRepository.getOne(id));

        return  "/aluno/notas";
    }
}
