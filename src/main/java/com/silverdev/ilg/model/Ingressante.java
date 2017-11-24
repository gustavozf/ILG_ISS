package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.PosicaoUEM;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

/**
 * Created by narcizo on 04/10/17.
 */
@Entity
public class Ingressante {

    @Id
    @Column(name= "ingressante_id")
    private Integer id;

    @CPF
    @Column(name = "ingressante_cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingressante_pos_uem")
    private PosicaoUEM posUem;

    @Column(name = "ingressante_curso")
    private Integer cod_curso;

    @Column(name = "ingressante_nomecurso")
    private String nome_curso;

    @Column(name = "ingressante_media")
    private double media = 0.0;

    @Column(name = "ingressante_quantNotas")
    private Integer quantNotas;

    @Column(name = "notas")
    private double notas = 0.0;

    @Column(name = "ingressante_sit_entrega")
    private boolean sit_entrega = false;

    @Column(name = "ingressante_sit_pagamento")
    private boolean sit_pagamento = false;

    @Column(name = "ingressante_inscricao")
    private Integer inscricao;

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

    public PosicaoUEM getPosUem() {
        return posUem;
    }

    public void setPosUem(PosicaoUEM posUem) {
        this.posUem = posUem;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Integer getQuantNotas() {
        return quantNotas;
    }

    public void setQuantNotas(Integer quantNotas) {
        this.quantNotas = quantNotas;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

    public boolean isSit_entrega() {
        return sit_entrega;
    }

    public void setSit_entrega(boolean sit_entrega) {
        this.sit_entrega = sit_entrega;
    }

    public boolean isSit_pagamento() {
        return sit_pagamento;
    }

    public void setSit_pagamento(boolean sit_pagamento) {
        this.sit_pagamento = sit_pagamento;
    }

    public Integer getInscricao() {
        return inscricao;
    }

    public void setInscricao(Integer inscricao) {
        this.inscricao = inscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingressante that = (Ingressante) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
