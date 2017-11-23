package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "inscricao_id")
    private Integer inscricao_id;

    @Column(name = "inscricao_ativo")
    private Boolean inscricao_ativa;

    @Column(name = "inscricao_data_inicio")
    private String data_ini;

    @Column(name = "inscricao_data_fim")
    private String data_fim;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscricao inscricao = (Inscricao) o;

        return inscricao_id != null ? inscricao_id.equals(inscricao.inscricao_id) : inscricao.inscricao_id == null;
    }

    @Override
    public int hashCode() {
        return inscricao_id != null ? inscricao_id.hashCode() : 0;
    }

    public Integer getInscricao_id() {
        return inscricao_id;
    }

    public void setInscricao_id(Integer inscricao_id) {
        this.inscricao_id = inscricao_id;
    }

    public Boolean getInscricao_ativa() {
        return inscricao_ativa;
    }

    public void setInscricao_ativa(Boolean inscricao_ativa) {
        this.inscricao_ativa = inscricao_ativa;
    }

    public String getData_ini() {
        return data_ini;
    }

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }
}
