package model;

import java.time.LocalDateTime;

public class EntregaExame {
    private Integer codExame;
    private Integer codResponsavel;
    private String retiradoPor;
    private LocalDateTime dataRetirada;

    public EntregaExame(Integer codExame, Integer codResponsavel, String retiradoPor) {
        this.codExame = codExame;
        this.codResponsavel = codResponsavel;
        this.retiradoPor = retiradoPor;
        this.dataRetirada = LocalDateTime.now();
    }

    public Integer getCodExame() {
        return codExame;
    }

    public void setCodExame(Integer codExame) {
        this.codExame = codExame;
    }

    public Integer getCodResponsavel() {
        return codResponsavel;
    }

    public void setCodResponsavel(Integer codResponsavel) {
        this.codResponsavel = codResponsavel;
    }

    public String getRetiradoPor() {
        return retiradoPor;
    }

    public void setRetiradoPor(String retiradoPor) {
        this.retiradoPor = retiradoPor;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    @Override
    public String toString() {
        return "EntregaExame{" +
                "codExame=" + codExame +
                ", codResponsavel=" + codResponsavel +
                ", retiradoPor='" + retiradoPor + '\'' +
                ", dataRetirada=" + dataRetirada +
                '}';
    }
}
