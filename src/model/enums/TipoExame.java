package model.enums;

public enum TipoExame {
    ELETROCARDIOGRAMA("ELETRO"),
    ECOCARDIOGRAMA("ECO"),
    ERGOMETRICO("ERGOMETRICO"),
    HOLTER("HOLTER");

    private String tipo;

    TipoExame(String tipo) {
            this.tipo = tipo;
        }
    public String getTipo() {
        return tipo;
    }
}
