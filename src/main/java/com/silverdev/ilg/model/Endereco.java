package com.silverdev.ilg.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by narcizo on 06/10/17.
 */
public class Endereco {
    @Id
    @CPF
    @Column(unique = true, name = "endereco_cpf")
    private String cpf;

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private int numero;

    @Column(name = "endereco_complemento")
    private String complemento;

    @Column(name = "endereco_cep")
    private String cep;
}

