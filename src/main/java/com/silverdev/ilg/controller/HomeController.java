package com.silverdev.ilg.controller;

import com.silverdev.ilg.general.Calendario;
import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.model.enums.Role;
import com.silverdev.ilg.repository.InscricaoRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping({"/","/index", "index.html"})
public class HomeController {
    private UsuarioRepository usuarioRepository;
    private InscricaoRepository inscricaoRepository;

    public HomeController(UsuarioRepository usuarioRepository, InscricaoRepository inscricaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.inscricaoRepository = inscricaoRepository;
    }

    @GetMapping
    public String home(Model model){
        Calendario calendario = new Calendario();
        boolean ativo = false;

        List<Inscricao> inscricoes = inscricaoRepository.findAll();
        Inscricao ultima = inscricoes.get(inscricoes.size()-1);

        //String inicio = ultima.getData_ini();
        //String fim = ultima.getData_fim();
        //String diahoje = calendario.getDayMonthYear();

        //<=0 se dataini for igual ou depois que hoje
        if((calendario.getDayMonthYear().compareTo(ultima.getData_ini()) <= 0) && (ultima.getData_fim().compareTo(calendario.getDayMonthYear())> 0)) {
            ativo = true;
        }

        model.addAttribute("ativo", ativo);


        return "index2";
    }

    @GetMapping("/redirectTipoUsuario")
    public String redirecionaUsuario(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String acesso = auth.getAuthorities().toString();
        acesso = acesso.replace("[", "");
        acesso = acesso.replace("]","");
        Integer id = usuarioRepository.findUsuarioByUsername(auth.getName()).getId();

        String retorno = "";
        if(acesso.equals(Role.ROLE_ADMIN.toString())){
            retorno = "redirect:/admin";
        } else if (acesso.equals(Role.ROLE_PROFESSOR.toString())){
            retorno = "redirect:/professor/"+ id;
        } else if (acesso.equals(Role.ROLE_ALUNO.toString())){
            retorno = "redirect:/aluno/" + id;
        } else if (acesso.equals(Role.ROLE_INGRESSANTE.toString())){
            retorno = "redirect:/ingressante/"+ id;
        } else if (acesso.equals(Role.ROLE_SECRETARIA.toString())){
            retorno = "redirect:/funcionario/"+ id;
        }

        return retorno;
    }
}
