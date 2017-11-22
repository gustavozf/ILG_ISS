package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer inscricao_id;

    @Column(name = "ativo")
    private Boolean inscricao_ativa;

    @Column(name = "data_inicio")
    private String data_ini;

    @Column(name = "data_fim")
    private String data_fim;



}
