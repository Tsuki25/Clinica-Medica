package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Enfermeiro extends Funcionario{
    private String cip;

    public Enfermeiro(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String senha, String cip) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, codFuncionario, senha);
        this.cip = cip;
    }

    public Enfermeiro(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, String senha, String cip) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, senha);
        this.cip = cip;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public Enfermeiro(){}

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "CIP=" + cip +
                ", codFuncionario=" + codFuncionario +
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
