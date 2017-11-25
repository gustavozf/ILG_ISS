package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Disputa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disputa_id")
    private Integer id;

    @Column(name = "disputa_ingressante")
    private Integer idIngressante;

    @Column(name = "disputa_curso")
    private Integer idCurso;

    @Column(name = "disputa_turma")
    private Integer idTurma;

    @Column(name="disputa_inscricao")
    private Integer inscricao;

    @Column(name = "disputa_posicao")
    private Integer posicao;

    @Column(name = "disputa_media")
    private double media;

    //Mensagem que aparece ao lado do status
    @Column(name = "disputa_mensagem")
    private String mensagem;

    //Se possui media >= 7.0, pagou o boleto e mandou os documentos
    @Column(name = "disputa_apto")
    private boolean apto;

    //se foi um dos selecionados
    @Column(name = "disputa_aprovado")
    private boolean aprovado;

    //se aceitou a vaga
    @Column(name = "disputa_matriculado")
    private boolean matriculado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdIngressante() {
        return idIngressante;
    }

    public void setIdIngressante(Integer idIngressante) {
        this.idIngressante = idIngressante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getInscricao() {
        return inscricao;
    }

    public void setInscricao(Integer inscricao) {
        inscricao = inscricao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disputa disputa = (Disputa) o;

        return id != null ? id.equals(disputa.id) : disputa.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
