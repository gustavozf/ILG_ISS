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

    @Column(name ="curso_ativo")
    private boolean ativo = true;

    @Column(name="curso_data_criacao")
    private String data_criacao;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Curso curso = (Curso) o;

        return id != null ? id.equals(curso.id) : curso.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
