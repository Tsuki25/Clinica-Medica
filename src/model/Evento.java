package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private Integer codEvento;
    private ProfissionalSaude reservante;
    private String motivo;
    private LocalDate data;
    private LocalTime horario;

    public Evento(Integer codEvento, ProfissionalSaude reservante, String motivo, LocalDate data, LocalTime horario) {
        this.codEvento = codEvento;
        this.reservante = reservante;
        this.motivo = motivo;
        this.data = data;
        this.horario = horario;
    }

    public Evento(){}

    public Integer getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(Integer codEvento) {
        this.codEvento = codEvento;
    }

    public ProfissionalSaude getReservante() {
        return reservante;
    }

    public void setReservante(ProfissionalSaude reservante) {
        this.reservante = reservante;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "codEvento=" + codEvento +
                ", reservante=" + reservante +
                ", motivo='" + motivo + '\'' +
                ", data=" + data +
                ", horario=" + horario +
                '}';
    }
}
