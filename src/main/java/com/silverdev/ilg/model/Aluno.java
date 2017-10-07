package com.silverdev.ilg.model;

import javax.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aluno_id")
    private Integer id;

    @Column(name = "aluno_nome")
    private String nome;

    @Column(name = "aluno_cpf")
    private String cpf;

    @Column(name = "aluno_rg")
    private Integer rg;

    @Column(name = "aluno_sobrenome")
    private String sobrenome;

    @Column(name = "aluno_sexo")
    private String sexo;

    @Column(name = "aluno_telefone")
    private String telefone;

    @Column(name = "aluno_nascimento")
    private String data_nascimento;

    @Column(name = "aluno_posicao")
    private Integer posicao_uem;

    @Column(name = "aluno_inscricao")
    private Integer num_inscricao;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getPosicao_uem() {
        return posicao_uem;
    }

    public void setPosicao_uem(Integer posicao_uem) {
        this.posicao_uem = posicao_uem;
    }

    public Integer getNum_inscricao() {
        return num_inscricao;
    }

    public void setNum_inscricao(Integer num_inscricao) {
        this.num_inscricao = num_inscricao;
    }
}
