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

    @Column(name="turma_professor")
    private String professor;

    @Column(name="turma_curso_id")
    private Integer curso_id;

    @Column(name="turma_num_vagas")
    private Integer num_vagas;

    @Column(name="turma_descricao")
    private String descricao;

    @Column(name="turma_data_criacao")
    private String data_criacao;

    @Column(name="turma_disponivel")
    private boolean disponivel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Integer getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Integer curso_id) {
        this.curso_id = curso_id;
    }

    public Integer getNum_vagas() {
        return num_vagas;
    }

    public void setNum_vagas(Integer num_vagas) {
        this.num_vagas = num_vagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turma turma = (Turma) o;

        return id != null ? id.equals(turma.id) : turma.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
