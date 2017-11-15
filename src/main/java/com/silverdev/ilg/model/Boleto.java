package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boleto_id")
    private Integer id;

    @Column(name = "boleto_vencimento")
    private String data_vencimento;

    @Column(name = "boleto_valor")
    private Integer valor;
}
