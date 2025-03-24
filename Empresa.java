import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<>();
    }
    public void CadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public Funcionario BuscarFuncionario(String matricula) {
        for(int i = 0; i < funcionarios.size(); i++){
            Funcionario aux = funcionarios.get(i);
            if(aux.getMatricula().equals(matricula)){
                return aux;
            }
        }
        return null;
    }

    public void RenomearFuncionario(Funcionario f, String novoNome) {
        f.setNome(novoNome);
    }

    public void AlterarEmail(Funcionario f, String email) {
        f.setEmail(email);
    }
}