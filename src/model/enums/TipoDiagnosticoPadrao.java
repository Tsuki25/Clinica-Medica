package model.enums;

import java.util.HashMap;

public enum TipoDiagnosticoPadrao {

    NORMAL_ADULTO("Texto padrão, normal adulto"),
    NORMAL_CRIANCA("Texto padrão, normal criança"),
    ALTERACAO_RELAXAMENTO_VE("Texto padrão, alteração do relaxamento do V.E."),
    PVM("Texto padrão, P.V.M"),
    OUTROS("Texto padrão, outros");

    private String tipo;

    TipoDiagnosticoPadrao(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}
