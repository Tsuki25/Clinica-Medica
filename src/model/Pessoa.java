package model;

import model.enums.Sexo;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String sobrenome;
    protected Sexo sexo;
    protected LocalDate dataNascimento;
    protected String telefone;
    protected String celular;
    protected String email;
    protected Endereco endereco;

    public Pessoa(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String telefone, String celular, String email, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = data_nascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
    }

    public Pessoa(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String celular, String email, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = data_nascimento;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
    }

    public Pessoa(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
                ", endereco=" + endereco +
                '}';
    }
}
