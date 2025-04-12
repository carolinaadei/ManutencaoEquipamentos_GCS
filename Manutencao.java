import java.time.LocalDate;

public class Manutencao {
    private final Equipamento equipamento;
    private String status;
    private String descricao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Funcionario funcionarioResponsavelEquipamento;
    private Funcionario funcionarioResponsavelManutencao;

    public Manutencao(Equipamento equipamento, String status, String descricao, LocalDate dataEntrada, LocalDate dataSaida, Funcionario funcionarioResponsavelEquipamento, Funcionario funcionarioResponsavelManutencao) {
        this.equipamento = equipamento;
        this.status = status;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.funcionarioResponsavelEquipamento = funcionarioResponsavelEquipamento;
        this.funcionarioResponsavelManutencao = funcionarioResponsavelManutencao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public Funcionario getFuncionarioResponsavelEquipamento() {
        return funcionarioResponsavelEquipamento;
    }

    public Funcionario getFuncionarioResponsavelManutencao() {
        return funcionarioResponsavelManutencao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setFuncionarioResponsavelEquipamento(Funcionario responsavelEquipamento) {
        this.funcionarioResponsavelEquipamento = responsavelEquipamento;
    }

    public void setFuncionarioResponsavelManutencao(Funcionario responsavelManutencao) {
        this.funcionarioResponsavelManutencao = responsavelManutencao;
    }

    public String toString() {
        return "Manutenção:" +
                " Equipamento: " + equipamento.getNomeCurto() +
                ". Status: " + status +
                ". Descrição: " + descricao +
                ". Data de Entrada: " + dataEntrada +
                ". Data de Saída: " + dataSaida +
                ". Funcionário Responsável pelo Equipamento: " + funcionarioResponsavelEquipamento.getNome() +
                ". Funcionário Responsável pela Manutenção: " + funcionarioResponsavelManutencao.getNome() +
                ".";
    }
}