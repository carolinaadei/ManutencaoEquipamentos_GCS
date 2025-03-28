import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<>();
    }
    public void CadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public Funcionario BuscarFuncionario(int matricula) {
        for(int i = 0; i < funcionarios.size(); i++){
            Funcionario aux = funcionarios.get(i);
            if(aux.getMatricula()==matricula){
                return aux;
            }
        }
        return null;
    }
}