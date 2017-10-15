package com.silverdev.ilg.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingresso_numinscricao")
    private Integer numinscricao;

    @CPF
    @Column(unique = true, name = "ingresso_cpf")
    private String cpf;

    @Column(name = "ingresso_codcurso")
    private Integer codcurso;

    @Column(name = "ingresso_codturma")
    private Integer codturma;

    @Column(name = "ingresso_sitpag")
    private Boolean sitpag;

    @Column(name = "ingresso_sitaceitacao")
    private Boolean sitaceitacao;

    public Integer getNuminscricao() {
        return numinscricao;
    }

    public void setNuminscricao(Integer numinscricao) {
        this.numinscricao = numinscricao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(Integer codcurso) {
        this.codcurso = codcurso;
    }

    public Integer getCodturma() {
        return codturma;
    }

    public void setCodturma(Integer codturma) {
        this.codturma = codturma;
    }

    public Boolean getSitpag() {
        return sitpag;
    }

    public void setSitpag(Boolean sitpag) {
        this.sitpag = sitpag;
    }

    public Boolean getSitaceitacao() {
        return sitaceitacao;
    }

    public void setSitaceitacao(Boolean sitaceitacao) {
        this.sitaceitacao = sitaceitacao;
    }
}
