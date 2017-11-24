package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Ingressante;
import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.repository.DisputaRepository;
import com.silverdev.ilg.repository.IngressanteRepository;
import com.silverdev.ilg.repository.InscricaoRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SelecaoController {

    private final UsuarioRepository usuarioRepository;
    private final IngressanteRepository ingressanteRepository;
    private final DisputaRepository disputaRepository;
    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public SelecaoController(UsuarioRepository usuarioRepository,
                             IngressanteRepository ingressanteRepository,
                             DisputaRepository disputaRepository,
                             InscricaoRepository inscricaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ingressanteRepository = ingressanteRepository;
        this.disputaRepository = disputaRepository;
        this.inscricaoRepository = inscricaoRepository;
    }

    public String RealizaSelecao(){

        return "redirect:/admin";
    }

    private List<Ingressante> BuscaHaptos(){
        List<Ingressante> ingressantes = null;
        Inscricao inscricao;
        Integer inscricao_id = getInscricaoId();

        if (inscricao_id != 0){
            inscricao = inscricaoRepository.getOne(inscricao_id);
            ingressantes = ingressanteRepository.findAllByInscricao(inscricao_id);

            for(Ingressante x: ingressantes){

            }

        } else {
            //erro, nenhuma inscricao gerada ainda
        }


        return ingressantes;
    }

    private void OrdenaMelhores(){

    }

    private Integer getInscricaoId(){
        List<Inscricao> inscricoes = inscricaoRepository.findAll();

        //Pega inscricao mais recente e retorna seu ID
        if(inscricoes != null && !inscricoes.isEmpty()){
            return inscricoes.get(inscricoes.size() -1).getInscricao_id();
        } else {
            return 0;
        }
    }
}
