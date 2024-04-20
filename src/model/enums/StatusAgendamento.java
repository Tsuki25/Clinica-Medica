package model.enums;

public enum StatusAgendamento {
    AGENDADO("agendado"),
    CONCLUIDO("concluido"),
    CANCELADO("cancelado");

    private String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
