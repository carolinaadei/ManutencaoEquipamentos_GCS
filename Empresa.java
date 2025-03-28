import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipamento> equipamentos;

    public Empresa() {
        funcionarios = new ArrayList<>();
        equipamentos = new ArrayList<>();
    }

    // Gerenciamento de Funcionários
    public void cadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public Funcionario buscarFuncionario(String matricula) {
        for (Funcionario aux : funcionarios) {
            if (aux.getMatricula().equals(matricula)) {
                return aux;
            }
        }
        return null;
    }

    public void renomearFuncionario(Funcionario f, String novoNome) {
        f.setNome(novoNome);
    }

    public void alterarEmail(Funcionario f, String email) {
        f.setEmail(email);
    }

  
    public void cadastrarEquipamento(Equipamento e) {
        equipamentos.add(e);
    }

    public Equipamento buscarEquipamento(String id) {
        for (Equipamento eq : equipamentos) {
            if (eq.getId().equals(id)) {
                return eq;
            }
        }
        return null;
    }

    public void editarDescricaoEquipamento(Equipamento e, String novaDescricao) {
        e.setDescricao(novaDescricao);
    }

    public void definirIndisponivel(Equipamento e) {
        e.setDisponivel(false);
    }
}
