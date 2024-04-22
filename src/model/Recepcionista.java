package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Date;

public class Recepcionista extends Funcionario{
    private int ramal;

    public Recepcionista(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String telefone, String celular, String email, Endereco endereco, Integer codFuncionario, String password, int ramal) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, endereco, codFuncionario, password);
        this.ramal = ramal;
    }

    public Recepcionista(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate dataNascimento, String celular, String email, Endereco endereco, Integer codFuncionario, String password, int ramal) {
        super(cpf, nome, sobrenome, sexo, dataNascimento, celular, email, endereco, codFuncionario, password);
        this.ramal = ramal;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "ramal=" + ramal +
                ", codFuncionario=" + codFuncionario +
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
