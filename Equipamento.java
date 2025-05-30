public class Equipamento {
    private Funcionario funcionarioResponsavel;
    private int id;
    private String nomeCurto;
    private String descricao;
    private String dataAquisicao;
    private final double valorAquisicao;
    private final String tipoEquipamento;
    private static int contadorId = 1;
    private String disponibilidade;
    private static boolean manutencao = false;
    private boolean disponibilidadeAtualizada;
    private boolean estragado = false;
    private String motivoDesabilitar = null;

    public Equipamento(String nomeCurto, String descricao, String dataAquisicao, double valorAquisicao,
                       Funcionario funcionarioResponsavel, String tipoEquipamento) {
        this.id = contadorId++;
        this.nomeCurto = nomeCurto;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        validarData(dataAquisicao);
        this.valorAquisicao = valorAquisicao;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.tipoEquipamento = tipoEquipamento;
        this.disponibilidade = "Disponível";
        this.manutencao = false;
    }

    private void validarData(String dataAquisicao) {
        if (!dataAquisicao.matches("\\d{2}[/.]\\d{2}[/.]\\d{4}")) {
            throw new IllegalArgumentException("Data de aquisição deve estar no formato 00/00/0000 ou 00.00.0000");
        }
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isDisponibilidadeAtualizada() {
        return disponibilidadeAtualizada;
    }

    public void setDisponibilidadeAtualizada(boolean disponibilidadeAtualizada) {
        this.disponibilidadeAtualizada = disponibilidadeAtualizada;
    }

    public int getId() {
        return id;
    }

    public String getNomeCurto() {
        return nomeCurto;
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

    public static boolean getManutencao() {
        return manutencao;
    }

    public void setEmManutencao(boolean manutencao) {
        this.manutencao = manutencao;
    }

    public boolean isEstragado() {
        return estragado;
    }

    public void setEstragado(boolean estragado) {
        this.estragado = estragado;
    }

    public String getMotivoDesabilitar() {
        return motivoDesabilitar;
    }

    public void setMotivoDesabilitar(String motivoDesabilitar) {
        this.motivoDesabilitar = motivoDesabilitar;
    }

    public void setDescricao(String novaDescricao) {
        descricao = novaDescricao;
    }
}