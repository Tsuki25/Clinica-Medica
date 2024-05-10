package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Recepcionista extends Funcionario{

    public Recepcionista(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, codFuncionario, password);
    }

    public Recepcionista(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, String password) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, password);
    }

    public Recepcionista(){}


    @Override
    public String toString() {
        return "Recepcionista{" +
                "codFuncionario=" + codFuncionario +
                ", password='" + senha + '\'' +
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
