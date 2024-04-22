package model.exames;

import model.Exame;

public class Holter extends Exame {
    private Integer ritmoCardiaco; // BPM
    private Double variabilidadeCardiaca;
    private Double intervaloQT; // s ou ms
    private Double intervaloPR; // s ou ms
    private String condIntraventricular;
    private String segmentoST;
    private String extrassistoles;
    private String arritmias;
    private String observacoes;

    public Holter(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio, Integer ritmoCardiaco, Double variabilidadeCardiaca,
                  Double intervaloQT, Double intervaloPR, String condIntraventricular, String segmentoST, String extrassistoles, String arritmias, String observacoes) {
        super(codExame, codDiagnostico, peso, altura, nomeSolicitante, convenio);
        this.ritmoCardiaco = ritmoCardiaco;
        this.variabilidadeCardiaca = variabilidadeCardiaca;
        this.intervaloQT = intervaloQT;
        this.intervaloPR = intervaloPR;
        this.condIntraventricular = condIntraventricular;
        this.segmentoST = segmentoST;
        this.extrassistoles = extrassistoles;
        this.arritmias = arritmias;
        this.observacoes = observacoes;
    }

    public Holter(){}

    public Integer getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public void setRitmoCardiaco(Integer ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public Double getVariabilidadeCardiaca() {
        return variabilidadeCardiaca;
    }

    public void setVariabilidadeCardiaca(Double variabilidadeCardiaca) {
        this.variabilidadeCardiaca = variabilidadeCardiaca;
    }

    public Double getIntervaloQT() {
        return intervaloQT;
    }

    public void setIntervaloQT(Double intervaloQT) {
        this.intervaloQT = intervaloQT;
    }

    public Double getIntervaloPR() {
        return intervaloPR;
    }

    public void setIntervaloPR(Double intervaloPR) {
        this.intervaloPR = intervaloPR;
    }

    public String getCondIntraventricular() {
        return condIntraventricular;
    }

    public void setCondIntraventricular(String condIntraventricular) {
        this.condIntraventricular = condIntraventricular;
    }

    public String getSegmentoST() {
        return segmentoST;
    }

    public void setSegmentoST(String segmentoST) {
        this.segmentoST = segmentoST;
    }

    public String getExtrassistoles() {
        return extrassistoles;
    }

    public void setExtrassistoles(String extrassistoles) {
        this.extrassistoles = extrassistoles;
    }

    public String getArritmias() {
        return arritmias;
    }

    public void setArritmias(String arritmias) {
        this.arritmias = arritmias;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Holter{" +
                "ritmoCardiaco=" + ritmoCardiaco +
                ", variabilidadeCardiaca=" + variabilidadeCardiaca +
                ", intervaloQT=" + intervaloQT +
                ", intervaloPR=" + intervaloPR +
                ", condIntraventricular='" + condIntraventricular + '\'' +
                ", segmentoST='" + segmentoST + '\'' +
                ", extrassistoles='" + extrassistoles + '\'' +
                ", arritmias='" + arritmias + '\'' +
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
