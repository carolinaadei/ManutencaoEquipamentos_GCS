import java.util.Scanner;

public class AppEquipamento {
    private Empresa empresa;
    Scanner in = new Scanner(System.in);

    public AppEquipamento() {
        empresa = new Empresa();
    }

    public void executar() {
        int opcao;
        do {
            menu();
            System.out.print("Opção desejada: ");
            opcao = in.nextInt();
            in.nextLine(); // Limpa buffer
            switch (opcao) {
                case 1:
                    cadastrarEquipamento();
                    break;
                case 2:
                    editarDescricao();
                    break;
                case 3:
                    marcarIndisponivel();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void menu() {
        System.out.println("///////////////////////////////////");
        System.out.println("Menu de Equipamentos:");
        System.out.println("///////////////////////////////////");
        System.out.println(
                "1 - Cadastrar equipamento \n" +
                "2 - Editar descrição do equipamento \n" +
                "3 - Marcar equipamento como indisponível \n" +
                "0 - Sair \n"
        );
    }

    private void cadastrarEquipamento() {
        System.out.print("Informe o ID do equipamento: ");
        String id = in.nextLine();

        System.out.print("Informe o nome do equipamento: ");
        String nome = in.nextLine();

        System.out.print("Informe a descrição do equipamento: ");
        String descricao = in.nextLine();

        System.out.print("Informe a data de aquisição (dd/MM/yyyy): ");
        String dataAquisicao = in.nextLine();

        System.out.print("Informe o valor de aquisição: ");
        double valorAquisicao = in.nextDouble();
        in.nextLine();

        System.out.print("Informe a matrícula do funcionário responsável: ");
        String matricula = in.nextLine();

        Funcionario responsavel = empresa.buscarFuncionario(matricula);
        if (responsavel == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        Equipamento e = new Equipamento(id, nome, descricao, dataAquisicao, valorAquisicao, responsavel.getNome());
        empresa.cadastrarEquipamento(e);
        System.out.println("Equipamento cadastrado com sucesso!");
    }

    private void editarDescricao() {
        System.out.print("Informe o ID do equipamento que deseja editar: ");
        String id = in.nextLine();

        Equipamento eq = empresa.buscarEquipamento(id);
        if (eq == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        System.out.print("Informe a nova descrição: ");
        String novaDescricao = in.nextLine();

        empresa.editarDescricaoEquipamento(eq, novaDescricao);
        System.out.println("Descrição atualizada com sucesso!");
    }

    private void marcarIndisponivel() {
        System.out.print("Informe o ID do equipamento que deseja marcar como indisponível: ");
        String id = in.nextLine();

        Equipamento eq = empresa.buscarEquipamento(id);
        if (eq == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        empresa.definirIndisponivel(eq);
        System.out.println("Equipamento marcado como indisponível.");
    }

    public static void main(String[] args) {
        AppEquipamento app = new AppEquipamento();
        app.executar();
    }
}
