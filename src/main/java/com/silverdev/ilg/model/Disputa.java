package com.silverdev.ilg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disputa {

    @Id
    @Column(name = "disputa_inscricao")
    private Integer num_inscricao;

    @Column(name = "disputa_curso")
    private Integer cod_curso;

    @Column(name = "disputa_turma")
    private Integer cod_turma;

    @Column(name = "disputa_posicao")
    private Integer posicao;

    @Column(name = "disputa_media")
    private float media;

    public Integer getNum_inscricao() {
        return num_inscricao;
    }

    public void setNum_inscricao(Integer num_inscricao) {
        this.num_inscricao = num_inscricao;
    }

    public Integer getCurso() {
        return cod_curso;
    }

    public void setCurso(Integer curso) {
        this.cod_curso = cod_curso;
    }

    public Integer getTurma() {
        return cod_turma;
    }

    public void setTurma(Integer turma) {
        this.cod_turma = cod_turma;
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
}
