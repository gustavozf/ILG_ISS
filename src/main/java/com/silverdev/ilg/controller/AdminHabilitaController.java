package com.silverdev.ilg.controller;

import com.silverdev.ilg.general.Calendario;
import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/habilitaInscricao")
public class AdminHabilitaController {

    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public AdminHabilitaController(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository = inscricaoRepository;
    }

    @InitBinder
    public void formataData(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String habilacao(Model model){

        List<Inscricao> inscricoes = inscricaoRepository.findAllByInscricaoAtiva(true);

        model.addAttribute("inscricao", inscricoes);

        return "/admin/habilitacao";
    }

    @GetMapping("/register")
    public String registerInscricao(Model model){
        model.addAttribute("inscricao", new Inscricao());

        return "/admin/registerInscricao";
    }

    @PostMapping("/register")
    public String registroInscricao(@Valid Inscricao inscricao, RedirectAttributes ra){
        Calendario calendario = new Calendario();

        //String[] data_atual = calendario.getDayMonthYear().split("/");
        //String[] data_inicio = inscricao.getData_ini().split("/");

        if((calendario.getDayMonthYear().compareTo(inscricao.getData_ini()) <= 0) && (inscricao.getData_fim().compareTo(inscricao.getData_ini()) > 0)) {
            ra.addFlashAttribute("sucesso", "Inscrição adicionada com sucesso!");
            inscricaoRepository.save(inscricao);
        }else{
            ra.addFlashAttribute("falha", "Datas inválidas!");
        }

        return "redirect:/admin/habilitaInscricao";
    }

    @GetMapping("/edit/{id}")
    public String editaInscricao(@PathVariable("id") Integer id, Model model){
        model.addAttribute("inscricao", inscricaoRepository.getOne(id));

        return "/admin/editInscricao";
    }

    @PostMapping("/edit/{id}")
    public String editaInsc(@PathVariable("id") Integer id, @Valid Inscricao inscricao, RedirectAttributes ra){
        inscricaoRepository.saveAndFlush(inscricao);
        ra.addFlashAttribute("editado", "Inscricao editada com sucesso!");

        return "redirect:/admin/habilitaInscricao";
    }

    @GetMapping("/delete/{id}")
    public String deletaInscricao(@PathVariable("id") Integer id, RedirectAttributes ra){
        Inscricao inscricao = inscricaoRepository.getOne(id);
        inscricao.setInscricaoAtiva(false);
        inscricaoRepository.saveAndFlush(inscricao);
        ra.addFlashAttribute("excluido", "Inscricao excluída com sucesso!");

        return "redirect:/admin/habilitaInscricao";
    }

}
