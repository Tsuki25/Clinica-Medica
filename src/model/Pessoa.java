package model;

import model.enums.Sexo;

import java.util.Date;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String sobrenome;
    protected Sexo sexo;
    protected Date dataNascimento;
    protected String telefone;
    protected String celular;
    protected String email;

    public Pessoa(String cpf, String nome, String sobrenome, Sexo sexo, Date data_nascimento, String telefone, String celular, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = data_nascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Pessoa(String cpf, String nome, String sobrenome, Sexo sexo, Date data_nascimento, String celular, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = data_nascimento;
        this.celular = celular;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {this.nome = nome;}

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

    public Date getData_nascimento() {
        return dataNascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
