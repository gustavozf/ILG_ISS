package com.silverdev.ilg.model;

import javax.persistence.*;

/**
 * Created by gustavozf on 04/10/17.
 */
@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "turma_id")
    private Integer id;


}
