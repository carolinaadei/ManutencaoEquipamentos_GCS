public class Equipamento {
    private int id;
    private static String nomeCurto;
    private String descricao;
    private String dataAquisicao;
    private final double valorAquisicao;
    private Funcionario funcionarioResponsavel;
    private final String tipoEquipamento;
    private static int contadorId = 1;
    private String disponibilidade = "";

    public Equipamento(String nomeCurto, String descricao, String dataAquisicao, double valorAquisicao, Funcionario funcionarioResponsavel, String tipoEquipamento) {
        validarData(dataAquisicao);
        this.id = contadorId++;
        this.nomeCurto = nomeCurto;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.tipoEquipamento = tipoEquipamento;
        this.disponibilidade = "Disponível";
    }

    private void validarData(String dataAquisicao) {
        if (!dataAquisicao.matches("\\d{2}[/.]\\d{2}[/.]\\d{4}")) {
            throw new IllegalArgumentException("Data de aquisição deve estar no formato 00/00/0000 ou 00.00.0000");
        }
    }

    public int getId() {
        return id;
    }

    public static String getNomeCurto() {
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

    public Funcionario getFuncionarioResponsavel() {
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