package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Disputa;
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
        Integer inscricao_id = getInscricaoId();
        List<Ingressante> ingressantes = ingressanteRepository.findAllByInscricao(inscricao_id);

        if(BuscaHaptos(inscricao_id, ingressantes)){

        }

        return "redirect:/admin";
    }

    private boolean BuscaHaptos(Integer inscricao_id, List<Ingressante> ingressantes){
        Disputa disputa_aux = null;

        if (inscricao_id != 0){
            for(Ingressante x: ingressantes){
                disputa_aux = new Disputa();
                disputa_aux.setId_ingressante(x.getId());
                disputa_aux.setId_curso(x.getCod_curso());
                disputa_aux.setId_turma(x.getTurma());
                disputa_aux.setMedia(x.getMedia());
                disputa_aux.setPosicao(0);
                disputa_aux.setInscricao(inscricao_id);

                if (x.isSit_entrega() && x.isSit_pagamento() && x.getMedia() > 0.0){
                    disputa_aux.setApto(true);
                    disputa_aux.setMensagem("Lista de Espera");
                } else {
                    disputa_aux.setApto(false);
                    disputa_aux.setMensagem("Não apto");
                }
                disputaRepository.save(disputa_aux);
            }

            return true;
        } else {
            //erro, nenhuma inscricao gerada ainda
            return false;
        }
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
