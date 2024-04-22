package model;

import model.enums.Sexo;

import java.util.Date;

public class ProfissionalSaude extends Funcionario {
    protected String numeroCarteira;

    public ProfissionalSaude(String cpf, String nome, String sobrenome, Sexo sexo, Date dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String password, String numeroCarteira) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, codFuncionario, password);
        this.numeroCarteira = numeroCarteira;
    }

    public ProfissionalSaude(String cpf, String nome, String sobrenome, Sexo sexo, Date dataNascimento, String celular, String email, Endereco endereco, Integer codFuncionario, String password, String numeroCarteira) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, celular, email, endereco, codFuncionario, password);
        this.numeroCarteira = numeroCarteira;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    @Override
    public String toString() {
        return "FuncionarioSaude{" +
                "numeroCarteira='" + numeroCarteira + '\'' +
                "} " + super.toString();
    }
}
