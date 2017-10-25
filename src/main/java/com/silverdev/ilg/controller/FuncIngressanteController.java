package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Ingressante;
import com.silverdev.ilg.repository.IngressanteRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.hibernate.validator.constraints.br.CPF;
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
@RequestMapping("/funcionario")
public class FuncIngressanteController {
    private final UsuarioRepository usuarioRepository;
    private final IngressanteRepository ingressanteRepository;

    @Autowired
    public FuncIngressanteController(UsuarioRepository usuarioRepository, IngressanteRepository ingressanteRepository){
        this.usuarioRepository = usuarioRepository;
        this.ingressanteRepository = ingressanteRepository;
    }

    @GetMapping
    public String telaFuncionario(){ return "/funcionario/index"; }

    //Cruds do funcionario

    @GetMapping("/funcIngressante")
    public String abreTelaFuncionario(Model model){
        model.addAttribute("ingressante", ingressanteRepository.findAll());

        return "/funcionario/funcIngressante";
    }

    @GetMapping("/insereQuantNotas/{id}")
    public String telaQuantNotasIngressante(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingressante", usuarioRepository.findOne(id));

        return "/funcionario/insereNotas";
    }
/*
    @PostMapping("/insereQuantNotas/{id}")
    public String editaQuantNotasIngressante(@PathVariable("id") Integer id, @Valid Ingressante ingressante, RedirectAttributes ra){
        ingressanteRepository.saveAndFlush(ingressante);
        ra.addFlashAttribute("editado", "editado com sucesso");

        return "redirect:/funcionario/insereNotas";
    }
*/
    @GetMapping("/insereNotas/{id}")
    public String telaEditaNotasIngressante(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingressante", ingressanteRepository.findOne(id));

        return "/funcionario/inserenotas";
    }

  /*  @PostMapping("/insereNotas/{id}")
    public String editaNotasIngressante(@PathVariable("id") Integer id, @Valid Ingressante ingressante, RedirectAttributes ra){
        ingressanteRepository.saveAndFlush(ingressante);
        ra.addFlashAttribute("editado", "editado com sucesso");
        float notas;

        notas = ingressante.getNotas() +

        return "redirect:/funcionario/insereNotas";
    }
*/
    @GetMapping("/calculaMedia/{id}")
    public String telacalculaMedia(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ingressanet", usuarioRepository.findOne(id));

        return "/funcionario/funcIngressante";
    }

    @PostMapping("/calculaMedia/{id}")
    public String calculaMediaIngressante(@PathVariable("id") Integer id, @Valid Ingressante ingressante, RedirectAttributes ra){
        float media;

        media = ingressante.getNotas()/ingressante.getQuantNotas();

        ingressante.setMedia(media);

        return "redirect:/funcionario/funcIngressante";
    }
}
