package model.exames;

import model.Exame;

public class Eletrocardiograma extends Exame {
    private String ritmo;
    private Integer funcaoCardiaca;
    private String conclusoes;

    public Eletrocardiograma(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio, String ritmo, Integer funcaoCardiaca, String conclusoes) {
        super(codExame, codDiagnostico, peso, altura, nomeSolicitante, convenio);
        this.ritmo = ritmo;
        this.funcaoCardiaca = funcaoCardiaca;
        this.conclusoes=conclusoes;
    }

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
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
                "ritmo='" + ritmo + '\'' +
                ", funcaoCardiaca=" + funcaoCardiaca +
                ", conclusoes='" + conclusoes +
                "} " + super.toString();
    }
}
