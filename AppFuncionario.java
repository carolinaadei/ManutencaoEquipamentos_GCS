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
        System.out.println("Menu de cadastro de funcionarios:");
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
        boolean validaMatricula;
        String matricula;

        do {
            in.nextLine();
            System.out.println("Informe a matrícula do funcionário: ");
            matricula = in.next();
            validaMatricula = verificaMatricula(matricula);
            if (!validaMatricula) {
                System.out.println("Matrícula inválida. Tente novamente.");
            }
        } while (!validaMatricula);
            in.nextLine();
            System.out.println("Informe a nome do Funcionario: ");
            String nome = in.nextLine();
            System.out.println("Informe a email do Funcionario: ");
            String email = in.nextLine();
            Funcionario f = new Funcionario(matricula, nome, email);
            empresa.CadastrarFuncionario(f);
            System.out.println("Funcionario cadastrado com sucesso!");
    }


        private void renomearFuncionaio() {
            in.nextLine();
            String matriculaNome;
                System.out.println("Informe a matricula do funcionario que deseja renomear: ");
                matriculaNome = in.nextLine();
            Funcionario aux = empresa.BuscarFuncionario(matriculaNome);
            if (aux == null) {
                System.out.println("funcionario não encontrado");
            } else {
                System.out.println("Informe o novo nome: ");
                String novoNome = in.nextLine();
                empresa.RenomearFuncionario(aux, novoNome);
                System.out.println("Funcionario renomeado com sucesso!");
            }
        }

        private void alterarEmail() {
            in.nextLine();
            System.out.println("Informe a matricula do funcionario que deseja alterar o email(sem os digitos comuns): ");
            String matriculaEmail = in.nextLine();
            Funcionario aux2 = empresa.BuscarFuncionario(matriculaEmail);
            if (aux2 == null) {
                System.out.println("Funcionario não encontrado");
            } else {
                System.out.println("Informe o novo email: ");
                String novoEmail = in.nextLine();
                empresa.AlterarEmail(aux2, novoEmail);
                System.out.println("Email alterado com sucesso!");
            }
        }

    public boolean verificaMatricula(String matricula) {
        if (matricula.length() < 3) {
            return false;
        }

        String verifica = matricula.substring(0, 3);
        return verifica.equals("101");
    }

}


