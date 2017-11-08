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
    @Column(unique = true, name = "ingressante_cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingressante_pos_uem")
    private PosicaoUEM posUem;


    @Column(name = "ingressante_curso")
    private Integer cod_curso;

    @Column(name = "ingressante_nomecurso")
    private String nome_curso;

    @Column(name = "ingressante_media")
    private float media;

    @Column(name = "ingressante_quantNotas")
    private Integer quantNotas;

    @Column(name = "notas")
    private float notas;

    @Column(name = "ingressante_sit_entrega")
    private boolean sit_entrega;

    @Column(name = "ingressante_sit_pagamento")
    private boolean sit_pagamento;

    /*@Column(unique = true, name = "ingressante_rg")
    private String rg;

    @Column(name = "ingressante_nome")
    private String nome;

    @Column(name = "ingressante_sobrenome")
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingressante_sexo")
    private Sexo sexo;

    @Column(name = "ingressante_telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "ingressante_data_nasc")
    private Date data_nasc;*/

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

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean getSit_entrega() {
        return sit_entrega;
    }

    public void setSit_entrega(boolean sit_entrega) {
        this.sit_entrega = sit_entrega;
    }

    public boolean getSit_pagamento() {
        return sit_pagamento;
    }

    public void setSit_pagamento(boolean sit_pagamento) {
        this.sit_pagamento = sit_pagamento;
    }

    public Integer getQuantNotas(){ return quantNotas;}

    public void setQuantNotas(Integer quantNotas){this.quantNotas = quantNotas;}

    public float getNotas(){return notas;}

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

    public void setNotas(float notas){this.notas = notas;}
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
