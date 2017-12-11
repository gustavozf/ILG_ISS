package com.silverdev.ilg.model;

import com.silverdev.ilg.model.enums.Estado;
import com.silverdev.ilg.model.enums.PosicaoUEM;
import com.silverdev.ilg.model.enums.Role;
import com.silverdev.ilg.model.enums.Sexo;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "usuario_data_nascimento")
    private String data_nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_tipo_acesso")
    private Role acesso;

    @Column(name="usuario_ativo")
    private boolean ativo = true;

    @Column(name="usuario_email")
    private String email;

    @Column(name="usuario_CEP")
    private String CEP;

    @Column(name="usuario_rua")
    private String rua;

    @Column(name="usuario_numero")
    private String numero;

    @Column(name="usuario_bairro")
    private String bairro;

    @Column(name="usuario_cidade")
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name="usuario_estado")
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name="usuario_PosUem")
    private PosicaoUEM posUEM;



    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public boolean isValid(){
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

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

    public Role getAcesso() {
        return acesso;
    }

    public void setAcesso(Role acesso) {
        this.acesso = acesso;
    }

    public PosicaoUEM getPosUEM() {
        return posUEM;
    }

    public void setPosUEM(PosicaoUEM posUEM) {
        this.posUEM = posUEM;
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

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + CEP + '\'' +
                ", logradouro='" + rua + '\'' +
                ", complemento='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + estado + '\'' +

                '}';
    }
}
