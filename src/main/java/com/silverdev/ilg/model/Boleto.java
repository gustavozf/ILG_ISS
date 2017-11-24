package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boleto_id")
    private Integer id;

    @Column(name = "boleto_numero")
    private Integer numero;

    @Column(name = "boleto_caminho")
    private String caminho;

    @Column(name = "boleto_valor")
    private Integer valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boleto boleto = (Boleto) o;

        return id != null ? id.equals(boleto.id) : boleto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
