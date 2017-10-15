package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by narcizo on 04/10/17.
 */
@Entity
public class Ingressante {

    @Id
    @Column(name= "ingressante_id")
    private Integer id;

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
    private Sexo sexo;

    @Column(name = "ingressante_telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "ingressante_data_nasc")
    private Date data_nasc;

    @Column(name = "ingressante_pos_uem")
    private Integer posUem;

    @Column(name = "ingressante_media")
    private float media;

    @Column(name = "ingressante_sit_entrega")
    private Integer sit_entrega;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingressante that = (Ingressante) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
