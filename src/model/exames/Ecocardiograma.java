package model.exames;

import model.Exame;

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

    public Ecocardiograma(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio, Integer raizAorta,
                          Integer atrioEsquerdo, Integer ventriculoDir, Integer ventriculoEsqSis, Integer ventriculoEsqDias, Integer ventriculoEsqParede,
                          Integer septoIntra, Double fraccaoEncurtamento, Double fraccaoEjecao) {
        super(codExame, codDiagnostico, peso, altura, nomeSolicitante, convenio);
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
                "} " + super.toString();
    }
}
