package model.exames;

import model.Exame;
import model.enums.TipoDiagnosticoPadrao;

public class Eletrocardiograma extends Exame {
    private String ritmoCardiaco;
    private Integer funcaoCardiaca;
    private String conclusoes;

    public Eletrocardiograma(Integer codExame, TipoDiagnosticoPadrao diagnostico, Double peso, Double altura, String convenio, Integer codFuncionario, Integer codPaciente, String ritmoCardiaco, Integer funcaoCardiaca, String conclusoes) {
        super(codExame, diagnostico, peso, altura, convenio, codFuncionario, codPaciente);
        this.ritmoCardiaco = ritmoCardiaco;
        this.funcaoCardiaca = funcaoCardiaca;
        this.conclusoes = conclusoes;
    }

    public Eletrocardiograma(Integer codExame) {
        super(codExame);
    }

    public Eletrocardiograma(){}

    public String getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public void setRitmoCardiaco(String ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public Integer getFuncaoCardiaca() {
        return funcaoCardiaca;
    }

    public void setFuncaoCardiaca(Integer funcaoCardiaca) {
        this.funcaoCardiaca = funcaoCardiaca;
    }

    public String getConclusoes() {
        return conclusoes;
    }

    public void setConclusoes(String conclusoes) {
        this.conclusoes = conclusoes;
    }

    @Override
    public String toString() {
        return "Eletrocardiograma{" +
                "ritmoCardiaco='" + ritmoCardiaco + '\'' +
                ", funcaoCardiaca=" + funcaoCardiaca +
                ", conclusoes='" + conclusoes + '\'' +
                ", codExame=" + codExame +
                ", diagnostico='" + diagnostico + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", convenio='" + convenio + '\'' +
                ", codFuncionario=" + codFuncionario +
                ", codPaciente=" + codPaciente +
                '}';
    }
}
