package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.Acesso;
import com.silverdev.ilg.model.enums.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name="usuario_username", unique = true)
    private String username;

    @Column(name = "usuario_password")
    private String password;

    @Column(unique = true, name = "usuario_rg")
    private String rg;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_sobrenome")
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_sexo")
    private Sexo sexo;

    @CPF
    @Column(unique = true, name = "usuario_cpf")
    private String cpf;

    @Column(name = "usuario_telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "usuario_data_nascimento")
    private Date data_nascimento;

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
        return data_nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.data_nascimento = nascimento;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id != null ? id.equals(usuario.id) : usuario.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
