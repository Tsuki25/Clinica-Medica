package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EntregaExame {
    private Integer codEntrega;
    private Integer codExame;
    private Integer codResponsavel;
    private String retiradoPor;
    private LocalDate dataRetirada;
    private LocalTime horarioRetirada;

    public EntregaExame(Integer codEntrega, Integer codExame, Integer codResponsavel, String retiradoPor, LocalDate dataRetirada, LocalTime horarioRetirada) {
        this.codEntrega = codEntrega;
        this.codExame = codExame;
        this.codResponsavel = codResponsavel;
        this.retiradoPor = retiradoPor;
        this.dataRetirada = dataRetirada;
        this.horarioRetirada = horarioRetirada;
    }

    public EntregaExame(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public EntregaExame() {}

    public Integer getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public LocalTime getHorarioRetirada() {
        return horarioRetirada;
    }

    public void setHorarioRetirada(LocalTime horarioRetirada) {
        this.horarioRetirada = horarioRetirada;
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

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    @Override
    public String toString() {
        return "EntregaExame{" +
                "codEntrega=" + codEntrega +
                ", codExame=" + codExame +
                ", codResponsavel=" + codResponsavel +
                ", retiradoPor='" + retiradoPor + '\'' +
                ", dataRetirada=" + dataRetirada +
                ", horarioRetirada=" + horarioRetirada +
                '}';
    }
}
