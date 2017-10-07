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

    @Column(name="turma_horario")
    private String horario;

    @Column(name="turma_professor")
    private String professor;

    @Column(name="turma_curso_id")
    private Integer curso_id;

    @Column(name="turma_num_vagas")
    private Integer num_vagas;

    @Column(name="turma_descricao")
    private String descricao;

    @Column(name="turma_disponivel")
    private Boolean disponivel;

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
