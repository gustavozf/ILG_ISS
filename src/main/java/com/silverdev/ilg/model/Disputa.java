package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Disputa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disputa_id")
    private Integer id;

    @Column(name = "disputa_ingressante")
    private Integer id_ingressante;

    @Column(name = "disputa_curso")
    private Integer id_curso;

    @Column(name = "disputa_turma")
    private Integer id_turma;

    @Column(name = "disputa_posicao")
    private Integer posicao;

    @Column(name = "disputa_media")
    private float media;

    private boolean hapto;

    private boolean aprovado;



}
