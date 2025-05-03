import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppManutencao {
    private static ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private Manutencao manutencao;
    private AppEquipamento appEquipamento;

    Scanner in = new Scanner(System.in);

    public AppManutencao() {
        this.appEquipamento = new AppEquipamento();
        this.manutencoes = new ArrayList<>();
    }

    public static ArrayList<Manutencao> getManutencoes() {
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
                    alterarStatusManutencao();
                    break;
                case 3:
                    exibirManutencaoMaisRecente();
                    break;
                case 4:
                    AppEquipamento.registrarEquipamentoDesabilitado();
                    break;
                case 5:
                    AppEquipamento.listarEquipamentosDesabilitados();
                    break;
                case 6:
                    listarEquipamentosEmManutencao();
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
        System.out.println("4 - Desabilitar um equipamento");
        System.out.println("5 - Listar equipamentos deshabilitados");
        System.out.println("6 - Listar equipamentos em manutenção");
        System.out.println("0 - Sair");
    }

    public static boolean isEmManutencao(Equipamento equipamento) {
        Manutencao manutencaoMaisRecente = null;

        for (Manutencao m : manutencoes) {
            System.out.println("Comparando ID do Equipamento: " + equipamento.getId() + " com ID da Manutenção: "
                    + m.getEquipamento().getId());

            if (m.getEquipamento().getId() == equipamento.getId()) {
                System.out.println("Encontrado equipamento com ID: " + equipamento.getId());
                if (manutencaoMaisRecente == null
                        || m.getDataEntrada().isAfter(manutencaoMaisRecente.getDataEntrada())) {
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
                funcionario);

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

    public void exibirUltimaManutencao(int idEquipamento) {
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

    private String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();
    }

    public void alterarStatusManutencao() {
        System.out.println("Alteração de status da manutenção");
        int idEquipamento = 0;

        while (true) {
            System.out.print("Informe o ID do equipamento: ");
            if (in.hasNextInt()) {
                idEquipamento = in.nextInt();
                in.nextLine();
                break;
            } else {
                System.out.println("Digite um número válido!");
                in.nextLine();
            }
        }

        Equipamento equipamento = AppEquipamento.buscarEquipamentoPorId(idEquipamento);
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }


        System.out.println("Equipamento: " + equipamento.getNomeCurto());
        System.out.println("Status atual: " + manutencao.getStatus());

        System.out.print("Digite o novo status (em espera, em andamento, finalizada): ");
        String entradaUsuario = in.nextLine().trim();
        String novoStatus = removerAcentos(entradaUsuario);

        Manutencao manutencaoMaisRecente = null;
        for (Manutencao m : getManutencoes()) {
            if (m.getEquipamento().getId() == idEquipamento) {
                if (manutencaoMaisRecente == null
                        || m.getDataEntrada().isAfter(manutencaoMaisRecente.getDataEntrada())) {
                    manutencaoMaisRecente = m;
                }
            }
        }

        if (manutencaoMaisRecente == null) {
            System.out.println("Nenhuma manutenção encontrada para este equipamento.");
            return;
        }

        String statusManutencao = removerAcentos(manutencao.getStatus());

        switch (novoStatus) {
            case "emEspera":
                if (statusManutencao.contains("em espera")) {
                    manutencao.setStatus("em espera");
                    equipamento.setEmManutencao(true);
                    manutencao.setStatus(novoStatus);
                    System.out.println("Manutenção do equipamento em espera.");
                }
                break;

            case "emAndamento":
                if (statusManutencao.contains("em andamento")) {
                    manutencao.setStatus("em andamento");
                    equipamento.setEmManutencao(true);
                    manutencao.setStatus(novoStatus);
                    System.out.println("Manutenção do equipamento em andamento.");
                }
                break;

            case "finalizada":
                if (statusManutencao.contains("finalizada")) {
                manutencao.setStatus("finalizada");
                equipamento.setEmManutencao(false);
                manutencao.setStatus(novoStatus);
                System.out.println("Manutenção do equipamento finalizada.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public void listarEquipamentosEmManutencao() {
        System.out.println("=== Equipamentos em Manutenção ===");
        boolean encontrou = false;

        for (Manutencao manutencao : manutencoes) {
            if (Equipamento.getManutencao()) {
                Equipamento equipamento = manutencao.getEquipamento();
                equipamento.getFuncionarioResponsavel();

                System.out.println("Equipamento: " + equipamento.getNomeCurto());
                System.out.println("Status da Manutenção: " + manutencao.getStatus());
                System.out.println("Funcionário Responsável: " + equipamento.getFuncionarioResponsavel());

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum equipamento está em manutenção no momento.\n");
        }
    }
}
