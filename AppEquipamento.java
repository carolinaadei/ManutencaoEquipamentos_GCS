import java.util.ArrayList;
import java.util.Scanner;

public class AppEquipamento {
    private Empresa empresa;
    Scanner in = new Scanner(System.in);

    public AppEquipamento(Empresa empresa) {
        this.empresa = empresa;
    }

    public void executar() {
        int opcao;
        do {
            menu();
            System.out.print("Opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarEquipamento();
                    break;
                case 2:
                    editarDescricao();
                    break;
                case 3:
                    marcarDisponibilidade();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void menu() {
        System.out.println("Menu dos Equipamentos");
        System.out.println("1 - Cadastrar equipamento");
        System.out.println("2 - Editar descrição do equipamento");
        System.out.println("3 - Marcar disponibilidade do equipamento");
        System.out.println("0 - Sair");
    }

    private void cadastrarEquipamento() {
        System.out.print("Informe o nome do equipamento: ");
        String nomeCurto = in.nextLine();
        System.out.print("Informe a descrição do equipamento: ");
        String descricao = in.nextLine();
        System.out.print("Informe a data de aquisição (dd/MM/yyyy): ");
        String dataAquisicao = in.nextLine();
        System.out.print("Informe o valor de aquisição: ");
        double valorAquisicao = in.nextDouble();
        in.nextLine();
        System.out.print("Informe o nome do funcionário responsável: ");
        String funcionarioResponsavelNome = in.nextLine();
        Funcionario funcionarioResponsavel = empresa.buscarFuncionarioPorNome(funcionarioResponsavelNome);
        if (funcionarioResponsavel == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }
        System.out.println("Informe o tipo do equipamento (fixo ou móvel): ");
        String tipoEquipamento = in.nextLine();
        System.out.println("Informe a disponibilidade do equipamento: ");
        String disponibilidade = in.nextLine();

        Equipamento e = new Equipamento(nomeCurto, descricao, dataAquisicao, valorAquisicao, funcionarioResponsavel.getNome(), tipoEquipamento);
        e.setDisponibilidade(disponibilidade);
        empresa.cadastrarEquipamento(e);
        System.out.println("Equipamento cadastrado com sucesso! Identificador: " + e.getId());
    }

    private void editarDescricao() {
        System.out.print("Informe o ID do equipamento que deseja editar: ");
        int id = in.nextInt();
        in.nextLine();
        Equipamento eq = empresa.buscarEquipamento(id);
        if (eq == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }
        System.out.print("Informe a nova descrição: ");
        String novaDescricao = in.nextLine();
        eq.setDescricao(novaDescricao);
        System.out.println("Descrição atualizada com sucesso!");
    }

    private void marcarDisponibilidade() {
        System.out.print("Informe o ID do equipamento que deseja marcar a disponibilidade: ");
        int id = in.nextInt();
        in.nextLine();
        Equipamento eq = empresa.buscarEquipamento(id);
        if (eq == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }
        System.out.println("Informe a nova disponibilidade (Disponível ou Indisponível): ");
        String disponibilidade = in.nextLine();
        eq.setDisponibilidade(disponibilidade);
        System.out.println("Disponibilidade do equipamento alterada com sucesso!");
    }
}