import java.util.ArrayList;
import java.util.Scanner;

public class AppManutencao {
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    Scanner in = new Scanner(System.in);

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
        System.out.println("1 - Adicionar equipamento para manutenção");
        System.out.println("2 - Alterar ststus de uma manutenção");
        System.out.println("3 - Exibir a última manutenção de um equipamento");
        System.out.println("4 - Exibir todas as manutenções de um equipamento");
        System.out.println("5 - Deshabilitar um equipamento");
        System.out.println("0 - Sair");
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
            System.out.println("Última manutenção: " + manutencaoMaisRecente.getDescricao() +
                    " em " + manutencaoMaisRecente.getDataEntrada());
        } else {
            System.out.println("Nenhuma manutenção registrada para este equipamento.");
        }
    }
}