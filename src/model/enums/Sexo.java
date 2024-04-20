package model.enums;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino");
    //NID("Não identificado");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
