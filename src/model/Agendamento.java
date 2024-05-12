package model;

import model.enums.StatusAgendamento;
import model.enums.TipoExame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Agendamento {
    private Integer codPaciente;
    private Integer codFuncionario;
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    private StatusAgendamento status;
    private TipoExame exame;

    public Agendamento(Integer codPaciente, Integer codFuncionario, LocalDate dataAgendamento, LocalTime horarioAgendamento, StatusAgendamento status, TipoExame exame) {
        this.codPaciente = codPaciente;
        this.codFuncionario = codFuncionario;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
        this.status = status;
        this.exame = exame;
    }

    public Agendamento(){}

    public Integer getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(LocalTime horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public TipoExame getExame() {
        return exame;
    }

    public void setExame(TipoExame exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "codPaciente=" + codPaciente +
                ", codFuncionario=" + codFuncionario +
                ", dataAgendamento=" + dataAgendamento +
                ", horarioAgendamento=" + horarioAgendamento +
                ", status=" + status +
                ", exame=" + exame +
                '}';
    }
}
