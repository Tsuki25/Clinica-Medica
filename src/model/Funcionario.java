package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario extends Pessoa{
    protected Integer codFuncionario;
    protected String password;

    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco);
        this.codFuncionario = codFuncionario;
        this.password = password; // VOLTAR AQUI PARA CRIPTOGRAFAR

    }

    public Funcionario(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone,celular, email, endereco);
    }

    public Funcionario(){}

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", password='" + password + '\'' +
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
