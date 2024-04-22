package model.exames;

import model.Exame;

public class Eletrocardiograma extends Exame {
    private String ritmoCardiaco;
    private Integer funcaoCardiaca;
    private String conclusoes;

    public Eletrocardiograma(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio, String ritmoCardiaco, Integer funcaoCardiaca, String conclusoes) {
        super(codExame, codDiagnostico, peso, altura, nomeSolicitante, convenio);
        this.ritmoCardiaco = ritmoCardiaco;
        this.funcaoCardiaca = funcaoCardiaca;
        this.conclusoes=conclusoes;
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
                ", nomeSolicitante='" + nomeSolicitante + '\'' +
                ", convenio='" + convenio + '\'' +
                ", codResponsavel=" + codResponsavel +
                '}';
    }
}
