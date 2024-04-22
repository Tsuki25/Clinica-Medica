package model;

import model.enums.Sexo;

import java.time.LocalDate;
import java.util.Arrays;

public class Paciente extends Pessoa{
    private Integer codPaciente;
    private String historico;
    private String[] alergias;
    private String[] medicamentosUtilizados;
    private String anotacoes;

    public Paciente(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String telefone, String celular, String email, Endereco endereco, Integer codPaciente, String historico, String[] alergias, String[] medicamentosUtilizados, String anotacoes) {
        super(cpf, nome, sobrenome, sexo, data_nascimento, telefone, celular, email, endereco);
        this.codPaciente = codPaciente;
        this.historico = historico;
        this.alergias = alergias;
        this.medicamentosUtilizados = medicamentosUtilizados;
        this.anotacoes = anotacoes;
    }

    public Paciente(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String celular, String email, Endereco endereco, Integer codPaciente, String historico, String[] alergias, String[] medicamentosUtilizados, String anotacoes) {
        super(cpf, nome, sobrenome, sexo, data_nascimento, celular, email, endereco);
        this.codPaciente = codPaciente;
        this.historico = historico;
        this.alergias = alergias;
        this.medicamentosUtilizados = medicamentosUtilizados;
        this.anotacoes = anotacoes;
    }

    public Paciente(){}

    public Integer getCodPaciente() { return codPaciente; }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public void setAlergias(String[] alergias) {
        this.alergias = alergias;
    }

    public String[] getMedicamentosUtilizados() {
        return medicamentosUtilizados;
    }

    public void setMedicamentosUtilizados(String[] medicamentosUtilizados) { this.medicamentosUtilizados = medicamentosUtilizados; }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codPaciente=" + codPaciente +
                ", historico='" + historico + '\'' +
                ", alergias=" + Arrays.toString(alergias) +
                ", medicamentosUtilizados=" + Arrays.toString(medicamentosUtilizados) +
                ", anotacoes='" + anotacoes + '\'' +
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
