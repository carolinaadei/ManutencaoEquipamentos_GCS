public class Equipamento {
    private String id;
    private String nome;
    private String descricao;
    private String dataAquisicao;
    private double valorAquisicao;
    private String funcionarioResponsavel;
    private boolean disponivel;

    public Equipamento(String id, String nome, String descricao, String dataAquisicao, double valorAquisicao, String funcionarioResponsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.disponivel = true; // Equipamento começa como disponível
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

