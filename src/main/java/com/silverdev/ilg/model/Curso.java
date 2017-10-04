package com.silverdev.ilg.model;

import javax.persistence.*;

/**
 * Created by gustavozf on 04/10/17.
 */
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curso_id")
    private Integer id;

    @Column(name = "curso_nome")
    private String nome;

    @Column(name = "curso_preco")
    private float preco;

    @Column(name = "curso_carga_horaria")
    private float carga_horaria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(float carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

}
