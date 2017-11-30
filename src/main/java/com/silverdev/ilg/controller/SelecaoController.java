package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Disputa;
import com.silverdev.ilg.model.Ingressante;
import com.silverdev.ilg.model.Inscricao;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.model.enums.PosicaoUEM;
import com.silverdev.ilg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/selecao/{id}")
public class SelecaoController {

    private final UsuarioRepository usuarioRepository;
    private final IngressanteRepository ingressanteRepository;
    private final DisputaRepository disputaRepository;
    private final InscricaoRepository inscricaoRepository;
    private final TurmaRepository turmaRepository;

    @Autowired
    public SelecaoController(UsuarioRepository usuarioRepository,
                             IngressanteRepository ingressanteRepository,
                             DisputaRepository disputaRepository,
                             InscricaoRepository inscricaoRepository,
                             TurmaRepository turmaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ingressanteRepository = ingressanteRepository;
        this.disputaRepository = disputaRepository;
        this.inscricaoRepository = inscricaoRepository;
        this.turmaRepository = turmaRepository;
    }

    public String RealizaSelecao(@PathVariable("id") Integer inscricao_id){
        List<Ingressante> ingressantes = ingressanteRepository.findAllByInscricao(inscricao_id);
        List<Disputa> disputas;
        Integer turma, vagasUem, vagasTotais, vagasFora;

        //acha os aptos de uma determinada inscricao
        BuscaAptos(inscricao_id, ingressantes);

        vagasFora = 0; //vagas dos alunos nao vinculados a uem
        vagasTotais = 0; //vagas da turma
        vagasUem = 0; // vagas dos alunos
        disputas = disputaRepository.findAllByInscricaoAndAptoOrderByIdTurmaAscMediaDesc(inscricao_id, true);
        turma = disputas.get(0).getIdTurma(); // pega o primeiro elemento da lista
        calculaVagas(turma, vagasTotais, vagasUem, vagasFora); // calcula o valor das vagas
        OrdenaMelhores(inscricao_id, disputas, vagasFora, vagasUem, vagasTotais, turma);


        return "redirect:/admin";
    }

    private void BuscaAptos(Integer inscricao_id, List<Ingressante> ingressantes){
        Disputa disputa_aux = null;

        for(Ingressante x: ingressantes){
            disputa_aux = new Disputa();
            disputa_aux.setIdIngressante(x.getId());
            disputa_aux.setIdCurso(x.getCod_curso());
            disputa_aux.setIdTurma(x.getTurma());
            disputa_aux.setMedia(x.getMedia());
            disputa_aux.setPosicao(0);
            disputa_aux.setInscricao(inscricao_id);

            if (x.isSit_entrega() && x.isSit_pagamento() && x.getMedia() > 7.0){
                disputa_aux.setApto(true);
                disputa_aux.setMensagem("Lista de Espera");
            } else {
                disputa_aux.setApto(false);
                disputa_aux.setMensagem("Não apto");
            }
            disputaRepository.save(disputa_aux);
        }
    }

    private void OrdenaMelhores(Integer inscricao_id,
                                List<Disputa> disputas,
                                Integer vagasFora,
                                Integer vagasUem,
                                Integer vagasTotais,
                                Integer turma){
        Integer cont1, cont2;
        Ingressante ingre;

        cont1 = 1; //contador da vaga dos vinculados a uem
        cont2 = 1; //contador da vaga dos nao vinculados a uem


        for (Disputa disputa: disputas) {
           if (!disputa.getIdTurma().equals(turma)){
                turma = disputa.getIdTurma();
                calculaVagas(turma, vagasTotais, vagasUem, vagasFora);
                cont1 = 1;
                cont2 = 1;
           }
            ingre = ingressanteRepository.getOne(disputa.getIdIngressante());
            if (isMembroUem(ingre.getId())){
                if(cont1 <=  vagasUem){
                    disputa.setAprovado(true);
                    disputa.setMensagem("Aprovado");
                }
                disputa.setPosicao(cont1);
                cont1 +=1;
            } else {
                if(cont2 <= vagasFora){
                    disputa.setAprovado(true);
                    disputa.setMensagem("Aprovado");
                }
                disputa.setPosicao(cont2);
                cont2 +=1;
            }
            disputaRepository.saveAndFlush(disputa);
        }


    }

    private void calculaVagas(Integer turmaId, Integer vagas, Integer daUem, Integer foraUem){
        Turma turma;
        Double aux;

        turma = turmaRepository.findById(turmaId);
        vagas = turma.getNum_vagas();
        aux = vagas*0.8;
        daUem = aux.intValue();
        foraUem = vagas - daUem;
    }

    private boolean isMembroUem(Integer idIngressante){
        return (ingressanteRepository.findById(idIngressante).getPosUem() != PosicaoUEM.DESC_00);
    }

    /*private Integer getInscricaoId(){
        List<Inscricao> inscricoes = inscricaoRepository.findAll();

        //Pega inscricao mais recente e retorna seu ID
        if(inscricoes != null && !inscricoes.isEmpty()){
            return inscricoes.get(inscricoes.size() -1).getInscricao_id();
        } else {
            return 0;
        }
    }*/
}
