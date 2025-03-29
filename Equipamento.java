public class Equipamento {
    private int id;
    private String nomeCurto;
    private String descricao;
    private String dataAquisicao;
    private double valorAquisicao;
    private String funcionarioResponsavel;
    private String tipoEquipamento;
    private static int contadorId = 1;
    private String disponibilidade = "";

    public Equipamento(String nomeCurto, String descricao, String dataAquisicao, double valorAquisicao, String funcionarioResponsavel, String tipoEquipamento) {
        this.id = contadorId++;
        this.nomeCurto = nomeCurto;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.tipoEquipamento = tipoEquipamento;
        this.disponibilidade = "Disponível";
    }

    public int getId() {
        return id;
    }

    public String getNomeCurto() {
        return nomeCurto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}