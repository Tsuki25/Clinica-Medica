package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
    private Integer codAgenda;
    private LocalDate dataReserva;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private Integer codFuncionario;
    private String motivo;

    public Agenda(){}

    public Agenda(Integer codAgenda, LocalDate dataReserva, LocalTime horarioInicio, LocalTime horarioFim, Integer codFuncionario, String motivo) {
        this.codAgenda = codAgenda;
        this.dataReserva = dataReserva;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.codFuncionario = codFuncionario;
        this.motivo = motivo;
    }

    public Agenda(Integer codAgenda){
        this.codAgenda = codAgenda;
    }

    public Integer getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(Integer codAgenda) {
        this.codAgenda = codAgenda;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }
    @Override
    public String toString() {
        return "Agenda{" +
                "codAgenda=" + codAgenda +
                ", dataReserva=" + dataReserva +
                ", horarioInicio=" + horarioInicio +
                ", horarioFim=" + horarioFim +
                ", codFuncionario=" + codFuncionario +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
