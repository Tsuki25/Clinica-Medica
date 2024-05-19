package model;

import model.enums.TipoDiagnosticoPadrao;

public class Exame {
    protected Integer codExame;
    protected TipoDiagnosticoPadrao diagnostico;
    protected Double peso;
    protected Double altura;
    protected String convenio;
    protected Integer codFuncionario;
    protected Integer codPaciente;

    public Exame(Integer codExame, TipoDiagnosticoPadrao diagnostico, Double peso, Double altura, String convenio, Integer codFuncionario, Integer codPaciente) {
        this.codExame = codExame;
        this.diagnostico = diagnostico;
        this.peso = peso;
        this.altura = altura;
        this.convenio = convenio;
        this.codFuncionario = codFuncionario;
        this.codPaciente = codPaciente;
    }

    public Exame(){}

    public Exame(Integer codExame) {
        this.codExame = codExame;
    }

    public Integer getCodExame() {
        return codExame;
    }

    public void setCodExame(Integer codExame) {
        this.codExame = codExame;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Integer getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
    }

    public TipoDiagnosticoPadrao getDiagnostico() {
        return diagnostico;
    }

    public String getDiagnosticoText() {
        return diagnostico.getTipo();
    }

    public void setDiagnostico(TipoDiagnosticoPadrao diagnostico) {
        this.diagnostico = diagnostico;
    }


    @Override
    public String toString() {
        return "Exame{" +
                "codExame=" + codExame +
                ", diagnostico='" + diagnostico.getTipo() + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", convenio='" + convenio + '\'' +
                ", codFuncionario=" + codFuncionario +
                ", codPaciente=" + codPaciente +
                '}';
    }
}
