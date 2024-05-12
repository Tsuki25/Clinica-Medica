package model.enums;

public enum TipoExame {
    ELETROCARDIOGRAMA("ELETROCARDIOGRAMA"),
    ECOCARDIOGRAMA("ECOCARDIOGRAMA"),
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
