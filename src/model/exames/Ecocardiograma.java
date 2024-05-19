package model.exames;

import model.Exame;
import model.enums.TipoDiagnosticoPadrao;

public class Ecocardiograma extends Exame {
    private Integer raizAorta;
    private Integer atrioEsquerdo;
    private Integer ventriculoDir;
    private Integer ventriculoEsqSis;
    private Integer ventriculoEsqDias;
    private Integer ventriculoEsqParede;
    private Integer septoIntra;
    private Double fraccaoEncurtamento;
    private Double fraccaoEjecao;

    public Ecocardiograma(Integer codExame, TipoDiagnosticoPadrao diagnostico, Double peso, Double altura, String convenio, Integer codFuncionario, Integer codPaciente, Integer raizAorta, Integer atrioEsquerdo, Integer ventriculoDir, Integer ventriculoEsqSis, Integer ventriculoEsqDias, Integer ventriculoEsqParede, Integer septoIntra, Double fraccaoEncurtamento, Double fraccaoEjecao) {
        super(codExame, diagnostico, peso, altura, convenio, codFuncionario, codPaciente);
        this.raizAorta = raizAorta;
        this.atrioEsquerdo = atrioEsquerdo;
        this.ventriculoDir = ventriculoDir;
        this.ventriculoEsqSis = ventriculoEsqSis;
        this.ventriculoEsqDias = ventriculoEsqDias;
        this.ventriculoEsqParede = ventriculoEsqParede;
        this.septoIntra = septoIntra;
        this.fraccaoEncurtamento = fraccaoEncurtamento;
        this.fraccaoEjecao = fraccaoEjecao;
    }

    public Ecocardiograma(Integer codExame) {
        super(codExame);
    }

    public Ecocardiograma(){}

    public Integer getRaizAorta() {
        return raizAorta;
    }

    public void setRaizAorta(Integer raizAorta) {
        this.raizAorta = raizAorta;
    }

    public Integer getAtrioEsquerdo() {
        return atrioEsquerdo;
    }

    public void setAtrioEsquerdo(Integer atrioEsquerdo) {
        this.atrioEsquerdo = atrioEsquerdo;
    }

    public Integer getVentriculoDir() {
        return ventriculoDir;
    }

    public void setVentriculoDir(Integer ventriculoDir) {
        this.ventriculoDir = ventriculoDir;
    }

    public Integer getVentriculoEsqSis() {
        return ventriculoEsqSis;
    }

    public void setVentriculoEsqSis(Integer ventriculoEsqSis) {
        this.ventriculoEsqSis = ventriculoEsqSis;
    }

    public Integer getVentriculoEsqDias() {
        return ventriculoEsqDias;
    }

    public void setVentriculoEsqDias(Integer ventriculoEsqDias) {
        this.ventriculoEsqDias = ventriculoEsqDias;
    }

    public Integer getVentriculoEsqParede() {
        return ventriculoEsqParede;
    }

    public void setVentriculoEsqParede(Integer ventriculoEsqParede) {
        this.ventriculoEsqParede = ventriculoEsqParede;
    }

    public Integer getSeptoIntra() {
        return septoIntra;
    }

    public void setSeptoIntra(Integer septoIntra) {
        this.septoIntra = septoIntra;
    }

    public Double getFraccaoEncurtamento() {
        return fraccaoEncurtamento;
    }

    public void setFraccaoEncurtamento(Double fraccaoEncurtamento) {
        this.fraccaoEncurtamento = fraccaoEncurtamento;
    }

    public Double getFraccaoEjecao() {
        return fraccaoEjecao;
    }

    public void setFraccaoEjecao(Double fraccaoEjecao) {
        this.fraccaoEjecao = fraccaoEjecao;
    }

    @Override
    public String toString() {
        return "Ecocardiograma{" +
                "raizAorta=" + raizAorta +
                ", atrioEsquerdo=" + atrioEsquerdo +
                ", ventriculoDir=" + ventriculoDir +
                ", ventriculoEsqSis=" + ventriculoEsqSis +
                ", ventriculoEsqDias=" + ventriculoEsqDias +
                ", ventriculoEsqParede=" + ventriculoEsqParede +
                ", septoIntra=" + septoIntra +
                ", fraccaoEncurtamento=" + fraccaoEncurtamento +
                ", fraccaoEjecao=" + fraccaoEjecao +
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
