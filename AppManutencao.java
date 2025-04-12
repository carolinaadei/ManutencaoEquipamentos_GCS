import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class AppManutencao {
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);
    private final AppFuncionario appFuncionario = new AppFuncionario();
    private final AppEquipamento appEquipamento = new AppEquipamento();
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void executar() {
        int opcao;
        do {
            menuManutencao();
            System.out.print("Opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    adicionarManutencao();
                    break;
                case 2:
                    alterarStatusManutencao();
                    break;
                case 3:
                    exibirManutencaoMaisRecente();
                    break;
                case 4:
                    exibirTodasManutencoesEquipamento();
                    break;
                case 5:
                    desabilitarEquipamento();
                    break;
                case 0:
                    System.out.println("Encerrando o menu de Manutenções.");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void menuManutencao() {
        System.out.println("Menu da Manutenção");
        System.out.println("1 - Adicionar equipamento para manutenção");
        System.out.println("2 - Alterar status de uma manutenção");
        System.out.println("3 - Exibir a última manutenção de um equipamento");
        System.out.println("4 - Exibir todas as manutenções de um equipamento");
        System.out.println("5 - Desabilitar um equipamento");
        System.out.println("0 - Sair");
    }

    private void adicionarManutencao() {
        System.out.print("Informe o ID do equipamento para manutenção: ");
        int idEquipamento = in.nextInt();
        in.nextLine();
        Equipamento equipamento = appEquipamento.buscarEquipamentoPorId(idEquipamento);
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        System.out.print("Informe o status da manutenção: ");
        String status = in.nextLine();
        System.out.print("Informe a descrição da manutenção: ");
        String descricao = in.nextLine();

        System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
        String dataEntradaStr = in.nextLine();
        LocalDate dataEntrada = parseDate(dataEntradaStr);
        if (dataEntrada == null) return;

        System.out.print("Informe a data de saída (dd/MM/yyyy), ou deixe em branco se ainda não saiu: ");
        String dataSaidaStr = in.nextLine();
        LocalDate dataSaida = null;
        if (!dataSaidaStr.isEmpty()) {
            dataSaida = parseDate(dataSaidaStr);
            if (dataSaida == null) return;
        }

        System.out.println("Informe o funcionário responsável pelo equipamento:");
        Funcionario funcionarioResponsavelEquipamento = appFuncionario.localizarFuncionarioPeloNome();
        if (funcionarioResponsavelEquipamento == null) return;

        System.out.println("Informe o funcionário responsável pela manutenção:");
        Funcionario funcionarioResponsavelManutencao = appFuncionario.localizarFuncionarioPeloNome();
        if (funcionarioResponsavelManutencao == null) return;

        Manutencao manutencao = new Manutencao(equipamento, status, descricao, dataEntrada, dataSaida, funcionarioResponsavelEquipamento, funcionarioResponsavelManutencao);
        manutencoes.add(manutencao);
        System.out.println("Manutenção adicionada com sucesso!");
    }

    private LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            return null;
        }
    }

    private void alterarStatusManutencao() {
        System.out.print("Informe o ID do equipamento para alterar o status da manutenção: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        List<Manutencao> manutencoesEquipamento = new ArrayList<>();
        for (Manutencao m : manutencoes) {
            if (m.getEquipamento().getId() == idEquipamento) {
                manutencoesEquipamento.add(m);
                System.out.println(manutencoesEquipamento.indexOf(m) + 1 + " - " + m.toString());
            }
        }

        if (manutencoesEquipamento.isEmpty()) {
            System.out.println("Nenhuma manutenção encontrada para este equipamento.");
            return;
        }

        System.out.print("Selecione o número da manutenção para alterar o status: ");
        int numeroManutencao = in.nextInt();
        in.nextLine();

        if (numeroManutencao > 0 && numeroManutencao <= manutencoesEquipamento.size()) {
            Manutencao manutencaoSelecionada = manutencoesEquipamento.get(numeroManutencao - 1);
            System.out.print("Informe o novo status: ");
            String novoStatus = in.nextLine();
            manutencaoSelecionada.setStatus(novoStatus);
            System.out.println("Status da manutenção atualizado com sucesso!");
        } else {
            System.out.println("Número de manutenção inválido.");
        }
    }

    public void exibirManutencaoMaisRecente() {
        System.out.print("Informe o ID do equipamento: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Manutencao manutencaoMaisRecente = null;

        for (Manutencao m : manutencoes) {
            if (m.getEquipamento().getId() == idEquipamento) {
                if (manutencaoMaisRecente == null || m.getDataEntrada().isAfter(manutencaoMaisRecente.getDataEntrada())) {
                    manutencaoMaisRecente = m;
                }
            }
        }
        if (manutencaoMaisRecente != null) {
            System.out.println("Última manutenção para o equipamento ID " + idEquipamento + ":");
            System.out.println(manutencaoMaisRecente.toString());
        } else {
            System.out.println("Nenhuma manutenção registrada para este equipamento.");
        }
    }

    public void exibirTodasManutencoesEquipamento() {
        System.out.print("Informe o ID do equipamento para exibir as manutenções: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        boolean encontrouManutencao = false;
        System.out.println("Manutenções para o equipamento ID " + idEquipamento + ":");
        for (Manutencao m : manutencoes) {
            if (m.getEquipamento().getId() == idEquipamento) {
                System.out.println("- " + m.toString());
                encontrouManutencao = true;
            }
        }

        if (!encontrouManutencao) {
            System.out.println("Nenhuma manutenção registrada para este equipamento.");
        }
    }

    public void desabilitarEquipamento() {
        System.out.print("Informe o ID do equipamento que deseja desabilitar: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Equipamento equipamento = appEquipamento.buscarEquipamentoPorId(idEquipamento);
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        equipamento.setDisponibilidade("Indisponível");
        System.out.println("Equipamento ID " + idEquipamento + " desabilitado.");
    }
}