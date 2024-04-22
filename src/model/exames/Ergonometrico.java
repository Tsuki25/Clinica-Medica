package model.exames;

import model.Exame;

public class Ergonometrico extends Exame {
    private boolean marcapasso;
    private boolean fumante;
    private String observacoes;

    public Ergonometrico(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio, boolean marcapasso, boolean fumante, String observacoes) {
        super(codExame, codDiagnostico, peso, altura, nomeSolicitante, convenio);
        this.marcapasso = marcapasso;
        this.fumante = fumante;
        this.observacoes = observacoes;
    }

    public Ergonometrico(){}

    public boolean isMarcapasso() {
        return marcapasso;
    }

    public void setMarcapasso(boolean marcapasso) {
        this.marcapasso = marcapasso;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Ergonometrico{" +
                "marcapasso=" + marcapasso +
                ", fumante=" + fumante +
                ", observacoes='" + observacoes + '\'' +
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
