package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.Acesso;
import com.silverdev.ilg.model.enums.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcionario_id")
    private Integer id;

    @Column(name = "funcionario_password")
    private String password;

    @Column(unique = true, name = "funcionario_rg")
    private String rg;

    @Column(name = "funcionario_nome")
    private String nome;

    @Column(name = "funcionario_sobrenome")
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(name = "funcionario_sexo")
    private Sexo sexo;

    @CPF
    @Column(unique = true, name = "funcionario_cpf")
    private String cpf;

    @Column(name = "funcionario_telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "funcionario_nascimento")
    private Date nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acesso")
    private Acesso acesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }
}
