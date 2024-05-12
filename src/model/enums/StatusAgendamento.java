package model.enums;

public enum StatusAgendamento {
    AGENDADO("AGENDADO"),
    CONCLUIDO("CONCLUIDO"),
    CANCELADO("CANCELADO");

    private String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
