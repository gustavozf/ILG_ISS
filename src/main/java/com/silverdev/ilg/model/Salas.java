package com.silverdev.ilg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salas {

    @Id
    @Column(name = "salas_inscricao")
    private Integer num_inscricao;

    @Column(name = "salas_curso")
    private Integer cod_curso;

    @Column(name = "salas_turma")
    private Integer cod_turma;

    @Column(name = "salas_cpf")
    private String cpf;

    @Column(name = "salas_prova1")
    private float prova1;

    @Column(name = "salas_aux1")
    private float prova_aux1;

    @Column(name = "salas_prova2")
    private float prova2;

    @Column(name = "salas_aux2")
    private float prova_aux2;

    @Column(name = "salas_aprovacao")
    private Boolean aprovacao;

    @Column(name = "salas_faltas")
    private Integer faltas;

    public Integer getNum_inscricao() {
        return num_inscricao;
    }

    public void setNum_inscricao(Integer num_inscricao) {
        this.num_inscricao = num_inscricao;
    }

    public Integer getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(Integer cod_curso) {
        this.cod_curso = cod_curso;
    }

    public Integer getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(Integer cod_turma) {
        this.cod_turma = cod_turma;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getProva1() {
        return prova1;
    }

    public void setProva1(float prova1) {
        this.prova1 = prova1;
    }

    public float getProva_aux1() {
        return prova_aux1;
    }

    public void setProva_aux1(float prova_aux1) {
        this.prova_aux1 = prova_aux1;
    }

    public float getProva2() {
        return prova2;
    }

    public void setProva2(float prova2) {
        this.prova2 = prova2;
    }

    public float getProva_aux2() {
        return prova_aux2;
    }

    public void setProva_aux2(float prova_aux2) {
        this.prova_aux2 = prova_aux2;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
}
