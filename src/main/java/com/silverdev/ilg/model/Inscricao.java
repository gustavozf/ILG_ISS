package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "inscricao_id")
    private Integer id;

    //Exclusao logica
    @Column(name = "inscricao_ativo")
    private boolean inscricaoAtiva = true;

    @Column(name = "inscricao_data_inicio")
    private String data_ini;

    @Column(name = "inscricao_data_fim")
    private String data_fim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscricao inscricao = (Inscricao) o;

        return id != null ? id.equals(inscricao.id) : inscricao.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isInscricaoAtiva() {
        return inscricaoAtiva;
    }

    public void setInscricaoAtiva(boolean inscricaoAtiva) {
        this.inscricaoAtiva = inscricaoAtiva;
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
