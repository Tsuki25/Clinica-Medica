package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
    private LocalDate data;
    private LocalTime horario;
    private ProfissionalSaude proprietario;
    private Object evento; // Pode ser um agendamento ou um evento externo de ausencia do funcionario

    public Agenda(){}

    public Agenda(LocalDate data, LocalTime horario, ProfissionalSaude proprietario, Object evento) {
        this.data = data;
        this.horario = horario;
        this.proprietario = proprietario;
        this.evento = evento;
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

    public ProfissionalSaude getProprietario() {
        return proprietario;
    }

    public void setProprietario(ProfissionalSaude proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "data=" + data +
                ", horario=" + horario +
                ", proprietario=" + proprietario +
                ", evento=" + evento +
                '}';
    }
}
