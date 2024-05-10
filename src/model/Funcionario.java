package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario extends Pessoa{
    protected Integer codFuncionario;
    protected String senha;

    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String senha) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco);
        this.codFuncionario = codFuncionario;
        this.senha = senha; // VOLTAR AQUI PARA CRIPTOGRAFAR

    }
    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, String senha) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone,celular, email, endereco);
    }

    public Funcionario(){}
    public Funcionario(Integer codFuncionario){
        this.codFuncionario = codFuncionario;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
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
