package model.exames;

import model.Exame;
import model.enums.TipoDiagnosticoPadrao;

public class Ergonometrico extends Exame {
    private Boolean marcapasso;
    private Boolean fumante;
    private String observacoes;

    public Ergonometrico(Integer codExame, TipoDiagnosticoPadrao diagnostico, Double peso, Double altura, String convenio, Integer codFuncionario, Integer codPaciente, Boolean marcapasso, Boolean fumante, String observacoes) {
        super(codExame, diagnostico, peso, altura, convenio, codFuncionario, codPaciente);
        this.marcapasso = marcapasso;
        this.fumante = fumante;
        this.observacoes = observacoes;
    }

    public Ergonometrico(Integer codExame) {
        super(codExame);
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
                ", convenio='" + convenio + '\'' +
                ", codFuncionario=" + codFuncionario +
                ", codPaciente=" + codPaciente +
                '}';
    }
}
