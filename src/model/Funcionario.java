package model;

import model.enums.Sexo;

import java.util.Date;

public class Funcionario extends Pessoa{
    private final Integer codFuncionario;
    private String password;

    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, Date dataNascimento, String telefone, String celular, String email, Integer codFuncionario, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email);
        this.codFuncionario = codFuncionario;
        this.password = password; // VOLTAR AQUI PARA CRIPTOGRAFAR

    }

    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, Date dataNascimento, String celular, String email, Integer codFuncionario, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, celular, email);
        this.codFuncionario = codFuncionario;
        this.password = password; // VOLTAR AQUI PARA CRIPTOGRAFAR
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
