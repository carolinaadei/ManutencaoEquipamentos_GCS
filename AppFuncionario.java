import java.util.Scanner;

public class AppFuncionario {
    private Empresa empresa;
    Scanner in = new Scanner(System.in);

    public AppFuncionario() {empresa  = new Empresa();}

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Informe a matricula do funcionario(Sem os digitos comuns): ");
                    String matricula = in.next();
                    in.nextLine();
                    System.out.println("Informe a nome do Funcionario: ");
                    String nome = in.nextLine();
                    System.out.print("Informe a email do Funcionario: ");
                    String email = in.nextLine();
                    Funcionario f = new Funcionario(matricula, nome, email);
                    empresa.CadastrarFuncionario(f);
                    break;

                case 2:
                    in.nextLine();
                    System.out.println("Informe a matricula do funcionario que deseja renomear(sem os digitos comuns): ");
                    String matriculaNome = "101" + in.nextLine().trim();
                    Funcionario aux = empresa.BuscarFuncionario(matriculaNome);
                    if (aux == null) {
                        System.out.println("funcionario não encontrado");
                    } else {
                        System.out.println("Informe o novo nome: ");
                        String novoNome = in.nextLine();
                        empresa.RenomearFuncionario(aux, novoNome);
                        System.out.println("Funcionario renomeado com sucesso!");
                    }
                    break;
                case 3:
                    in.nextLine();
                    System.out.println("Informe a matricula do funcionario que deseja alterar o email(sem os digitos comuns): ");
                    String matriculaEmail = "101" + in.nextLine().trim();
                    Funcionario aux2 = empresa.BuscarFuncionario(matriculaEmail);
                    if (aux2 == null) {
                        System.out.println("Funcionario não encontrado");
                    } else {
                        System.out.println("Informe o novo email: ");
                        String novoEmail = in.nextLine();
                        empresa.AlterarEmail(aux2, novoEmail);
                        System.out.println("Email alterado com sucesso!");
                    }
                    break;
            }
        }while (opcao != 0) ;
    }


        private void menu () {
            System.out.println(
                    "1-Cadastrar funcionario \n" + "2-Alterar nome de funcionario \n" + "3-Alterar email de funcionario \n" + "0- Sair \n"
            );
        }
    }