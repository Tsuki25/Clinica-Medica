package model;

import java.util.HashMap;

public class Exame {
    private static final HashMap<String, String> mapDiagnostico = new HashMap<>();//CRIA O MAPA DE DIAGNOSTICOS DISPONIVEIS PARA O EXAME
    static {
        // Adicionando valores predefinidos ao HashMap
        mapDiagnostico.put("NORMALADULTO", "texto padrão, normal adulto");
        mapDiagnostico.put("NORMALCRIANCA", "texto padrão, normal criança");
        mapDiagnostico.put("ALTERACAORELAXAMENTOVE", "texto padrão, alteração do relaxamento do V.E.");
        mapDiagnostico.put("PVM", "texto padrão, P.V.M");
        mapDiagnostico.put("OUTROS", "texto padrão, outros");
    }

    protected final Integer codExame;
    protected String diagnostico;
    protected Double peso;
    protected Double altura;
    protected String nomeSolicitante;
    protected String convenio;
    protected Integer codResponsavel;

    public Exame(Integer codExame, String codDiagnostico, Double peso, Double altura, String nomeSolicitante, String convenio) {
        this.codExame = codExame;
        this.diagnostico = mapDiagnostico.get(codDiagnostico);
        this.peso = peso;
        this.altura = altura;
        this.nomeSolicitante = nomeSolicitante;
        this.convenio = convenio;
    }

    public Integer getCodResponsavel() {
        return codResponsavel;
    }

    public void setCodResponsavel(Integer codResponsavel) {
        this.codResponsavel = codResponsavel;
    }

    public Integer getCodExame() {
        return codExame;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    // METODOS DE MANIPULAÇÃO DO HASH MAP =============================================================================
    public static void adicionarDiagnostico(String chave, String descricao) {
        mapDiagnostico.put(chave, descricao);
    }

    public static void atualizarDescricao(String chave, String novaDescricao) {
        mapDiagnostico.put(chave, novaDescricao);
    }

    public static void removerDiagnostico(String chave) {
        mapDiagnostico.remove(chave);
    }
    // METODOS DE MANIPULAÇÃO DO HASH MAP =============================================================================
    @Override
    public String toString() {
        return "Exame{" +
                "codExame=" + codExame +
                ", diagnostico='" + diagnostico + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", nomeSolicitante='" + nomeSolicitante + '\'' +
                ", convenio='" + convenio + '\'' +
                '}';
    }
}
