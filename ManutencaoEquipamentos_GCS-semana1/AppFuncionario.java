import java.util.Scanner;

public class AppFuncionario {
    private Empresa empresa;
    Scanner in = new Scanner(System.in);

    public AppFuncionario(Empresa empresa) {
        this.empresa = empresa;
    }

    public void executar() {
        int opcao;
        do {
            menu();
            System.out.print("Opção desejada: ");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    renomearFuncionario();
                    break;
                case 3:
                    alterarEmail();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (opcao != 0);
    }

    private void menu() {
        System.out.println("Menu dos Funcionários: ");
        System.out.println("1 - Cadastrar funcionario");
        System.out.println("2 - Renomear um funcionario");
        System.out.println("3 - Alterar email de funcionario");
        System.out.println("0 - Sair");
    }

    private void cadastrarFuncionario() {
        in.nextLine();
        System.out.println("Informe o nome do Funcionario: ");
        String nome = in.nextLine();
        System.out.println("Informe o email do Funcionario: ");
        String email = in.nextLine();

        Funcionario f = new Funcionario(nome, email);
        empresa.cadastrarFuncionario(f);

        System.out.println("Funcionario cadastrado com sucesso! Matrícula: " + f.getMatricula());
    }

    private void renomearFuncionario() {
        in.nextLine();
        System.out.println("Informe a matrícula do funcionário que deseja renomear: ");
        int matricula = in.nextInt();
        Funcionario aux = empresa.buscarFuncionario(matricula);
        if (aux == null) {
            System.out.println("Funcionário não encontrado!");
        } else {
            System.out.println("Informe o novo nome: ");
            in.nextLine();
            String novoNome = in.nextLine();
            aux.setNome(novoNome);
            System.out.println("Funcionário renomeado com sucesso!");
        }
    }

    private void alterarEmail() {
        in.nextLine();
        System.out.println("Informe a matrícula do funcionário que deseja alterar o email: ");
        int matricula = in.nextInt();

        Funcionario aux2 = empresa.buscarFuncionario(matricula);
        if (aux2 == null) {
            System.out.println("Funcionário não encontrado!");
        } else {
            System.out.println("Informe o novo email: ");
            in.nextLine();
            String novoEmail = in.nextLine();
            aux2.setEmail(novoEmail);
            System.out.println("Email alterado com sucesso!");
        }
    }
}