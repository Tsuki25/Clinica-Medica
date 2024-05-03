package model;

public class Endereco {
    private Integer codEnd;
    private Integer cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer numero;
    private String complemento;

    public Endereco(Integer codEnd, Integer cep, String logradouro, String bairro, String cidade, String estado, Integer numero, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }
    public Endereco(){}

    public Endereco(Integer cep, Integer numero, String complemento) { // CASO SEJA POSSIVEL IMPLEMENTAR API DOS CORREIOS
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(Integer codEndereco){//usado para facilitar a busca por endereços no banco de dados
        this.codEnd = codEndereco;
    }

    public Integer getCodEnd() {
        return codEnd;
    }

    public void setCodEnd(Integer codEnd) {
        this.codEnd = codEnd;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep=" + cep +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
