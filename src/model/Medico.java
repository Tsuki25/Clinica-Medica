package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Medico extends Funcionario{
    private String crm;

    public Medico(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String senha, String crm) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, codFuncionario, senha);
        this.crm = crm;
    }

    public Medico(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, String senha, String crm) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, senha);
        this.crm = crm;
    }

    public Medico(){}

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM=" + crm +
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

