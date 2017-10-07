package com.silverdev.ilg.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

/**
 * Created by narcizo on 04/10/17.
 */
@Entity
public class Ingressante {

    @CPF
    @Column(unique = true, name = "ingressante_cpf")
    private String cpf;

    @Column(unique = true, name = "ingressante_rg")
    private String rg;

    @Column(name = "ingressante_nome")
    private String nome;

    @Column(name = "ingressante_sobrenome")
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(name = "ingressante_sexo")
    private char sexo;

    @Column(name = "ingressante_telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "ingressante_data_nasc")
    private String data_nasc;

    @Column(name = "ingressante_pos_uem")
    private int posUem;

    @Column(name = "ingressante_media")
    private float media;

    @Column(name = "ingressante_sit_entrega")
    private int sit_entrega;


}
