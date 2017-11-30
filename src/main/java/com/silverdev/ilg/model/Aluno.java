package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.PosicaoUEM;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aluno_id")
    private Integer id;

    @CPF
    @Column(name = "aluno_cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "aluno_posicao")
    private PosicaoUEM posicao_uem;

    @Column(name = "aluno_curso")
    private Integer cod_curso;

    @Column(name = "aluno_nomecurso")
    private String nome_curso;

    @Column(name = "aluno_turma")
    private Integer cod_turma;

    @Column(name = "aluno_prova1")
    private double prova1;

    @Column(name = "aluno_aux1")
    private double prova_aux1;

    @Column(name = "aluno_prova2")
    private double prova2;

    @Column(name = "aluno_aux2")
    private double prova_aux2;

    @Column(name = "aluno_aprovacao")
    private boolean aprovacao;

    @Column(name = "media")
    private double media;

    @Column(name = "aluno_faltas")
    private Integer faltas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PosicaoUEM getPosicao_uem() {
        return posicao_uem;
    }

    public void setPosicao_uem(PosicaoUEM posicao_uem) {
        this.posicao_uem = posicao_uem;
    }

    public Integer getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(Integer cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public Integer getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(Integer cod_turma) {
        this.cod_turma = cod_turma;
    }

    public double getProva1() {
        return prova1;
    }

    public void setProva1(double prova1) {
        this.prova1 = prova1;
    }

    public double getProva_aux1() {
        return prova_aux1;
    }

    public void setProva_aux1(double prova_aux1) {
        this.prova_aux1 = prova_aux1;
    }

    public double getProva2() {
        return prova2;
    }

    public void setProva2(double prova2) {
        this.prova2 = prova2;
    }

    public double getProva_aux2() {
        return prova_aux2;
    }

    public void setProva_aux2(double prova_aux2) {
        this.prova_aux2 = prova_aux2;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return id != null ? id.equals(aluno.id) : aluno.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
