package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Disputa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disputa_id")
    private Integer id;

    @Column(name = "disputa_ingressante")
    private Integer id_ingressante;

    @Column(name = "disputa_curso")
    private Integer id_curso;

    @Column(name = "disputa_turma")
    private Integer id_turma;

    @Column(name = "disputa_posicao")
    private Integer posicao;

    @Column(name = "disputa_media")
    private float media;

    //Se possui meida >= 7.0, pagou o boleto e mandou os documentos
    @Column(name = "disputa_hapto")
    private boolean hapto;

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

    public Integer getId_ingressante() {
        return id_ingressante;
    }

    public void setId_ingressante(Integer id_ingressante) {
        this.id_ingressante = id_ingressante;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getId_turma() {
        return id_turma;
    }

    public void setId_turma(Integer id_turma) {
        this.id_turma = id_turma;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean isHapto() {
        return hapto;
    }

    public void setHapto(boolean hapto) {
        this.hapto = hapto;
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
