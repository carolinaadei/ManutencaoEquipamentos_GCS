import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AppManutencao {
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private Equipamento equipamento;
    private Funcionario funcionario;
    private AppEquipamento appEquipamento;
    Scanner in = new Scanner(System.in);

    public AppManutencao() {
        this.appEquipamento = appEquipamento;
    }

    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void executar() {
        int opcao;
        do {
            menuManutencao();
            System.out.println("Opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    novaManutencao();
                    break;
                case 2:
                    break;
                case 3:
                    exibirManutencaoMaisRecente();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void menuManutencao() {
        System.out.println("Menu da Manutenção");
        System.out.println("1 - Criar uma nova manutenção");
        System.out.println("2 - Alterar status de uma manutenção");
        System.out.println("3 - Exibir a última manutenção de um equipamento");
        System.out.println("4 - Exibir todas as manutenções de um equipamento");
        System.out.println("5 - Deshabilitar um equipamento");
        System.out.println("0 - Sair");
    }

    public boolean isEmManutencao(Equipamento equipamento) {
        Manutencao manutencaoMaisRecente = null;

        for (Manutencao m : manutencoes) {
            if (m.getEquipamento().getId() == equipamento.getId()) {
                if (manutencaoMaisRecente == null ||
                        m.getDataEntrada().isAfter(manutencaoMaisRecente.getDataEntrada())) {
                    manutencaoMaisRecente = m;
                }
            }
        }

        if (manutencaoMaisRecente != null) {
            String status = manutencaoMaisRecente.getStatus();

            if (!status.equalsIgnoreCase("concluída")) {
                System.out.println("O equipamento está em manutenção - status: " + status);
                return true;
            } else {
                System.out.println("O equipamento não está em manutenção - última manutenção realizada "
                        + manutencaoMaisRecente.getDataEntrada());
            }
        } else {
            System.out.println("O equipamento não está em manutenção - nenhuma manutenção registrada.");
        }

        return false;
    }

    private LocalDate gerarDataAtual() {
        return LocalDate.now();
    }

    private LocalDate gerarDataSaida() {
        return LocalDate.now();
    }

    private void novaManutencao() {
        LocalDate dataEntrada = gerarDataAtual();
        LocalDate dataSaida = gerarDataSaida();
        String estado = "Solicitada";
        boolean isEmManutencao = true;

        System.out.println("Novo Registro de Manutenção");
        System.out.print("Informe o ID do equipamento: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Equipamento equipamento = AppEquipamento.buscarEquipamentoPorId(idEquipamento);
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        System.out.println("Equipamento selecionado: " + equipamento.getNomeCurto());
        equipamento.setDisponibilidade("Indisponível");
        System.out.print("Descrição do Problema: ");
        String descricaoProblema = in.nextLine();

        Funcionario funcionario = AppFuncionario.localizarFuncionarioPeloNome();
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.println("Funcionário: " + funcionario.getNome());

        Manutencao nova = new Manutencao(
                equipamento,
                estado,
                isEmManutencao,
                descricaoProblema,
                dataEntrada,
                dataSaida,
                funcionario
        );

        manutencoes.add(nova);
        System.out.println("Manutenção registrada com sucesso!");
        System.out.println("→ Equipamento agora está com disponibilidade: " + equipamento.getDisponibilidade());
    }

    public void exibirManutencaoMaisRecente() {
        System.out.print("Informe o ID do equipamento: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Manutencao manutencaoMaisRecente = null;

        for (Manutencao m : manutencoes) {
            if (m.getEquipamento().getId() == idEquipamento) {
                if (manutencaoMaisRecente == null ||
                        m.getDataEntrada().isAfter(manutencaoMaisRecente.getDataEntrada())) {
                    manutencaoMaisRecente = m;
                }
            }
        }

        if (manutencaoMaisRecente != null) {
            System.out.println("Última manutenção: " + manutencaoMaisRecente.getDescricaoProblema() +
                    " em " + manutencaoMaisRecente.getDataEntrada());
        } else {
            System.out.println("Nenhuma manutenção registrada para este equipamento.");
        }
    }
}