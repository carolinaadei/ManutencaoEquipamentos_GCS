import java.util.Scanner;

public class AppFuncionario {
    private Empresa empresa;
    Scanner in = new Scanner(System.in);

    public AppFuncionario() {
        empresa = new Empresa();
    }

    public void executar() {
        int opcao;
        do {
            menu();
            System.out.print("Opção desejada: ");
            opcao = in.nextInt();
            switch (opcao) {  // Criar metodos que tenha os cases e chama-los, corretamente no Switch.
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    renomearFuncionaio();
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
        System.out.println("///////////////////////////////////");
        System.out.println("Menu do funcionário:");
        System.out.println("///////////////////////////////////");
        // Menu criado para o bom gerenciameto dos funcionarios classes
        System.out.println(
                "1-Cadastrar funcionario \n" +
                        "2-Alterar nome de funcionario \n" +
                        "3-Alterar email de funcionario \n" +
                        "0- Sair \n"
        );
    }

    private void cadastrarFuncionario() {
        in.nextLine();
        System.out.println("Informe a nome do Funcionário: ");
        String nome = in.nextLine();
        System.out.println("Informe a email do Funcionário: ");
        String email = in.nextLine();

        Funcionario f = new Funcionario(nome, email);
        empresa.CadastrarFuncionario(f);

        System.out.println("Funcionário cadastrado com sucesso! Matrícula: " + f.getMatricula());
    }


    private void renomearFuncionaio() {
        in.nextLine();
        System.out.println("Informe a matricula do funcionário que deseja renomear: ");
        int matricula = in.nextInt();
        Funcionario aux = empresa.BuscarFuncionario(matricula);
        if (aux == null) {
            System.out.println("funcionário não encontrado");
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
        System.out.println("Informe a matricula do funcionário que deseja alterar o email: ");
        int matricula = in.nextInt();
        Funcionario aux2 = empresa.BuscarFuncionario(matricula);
        if (aux2 == null) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println("Informe o novo email: ");
            in.nextLine();
            String novoEmail = in.nextLine();
            aux2.setEmail(novoEmail);
            System.out.println("Email alterado com sucesso!");
        }
    }
}