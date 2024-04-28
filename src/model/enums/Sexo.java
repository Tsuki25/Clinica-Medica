package model.enums;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    //NID("Não identificado");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
