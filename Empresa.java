import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipamento> equipamentos;

    public Empresa() {
        funcionarios = new ArrayList<>();
        equipamentos = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(int matricula) {
        for (Funcionario aux : funcionarios) {
            if (aux.getMatricula() == matricula) {
                return aux;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return null;
        }
        for (Funcionario aux : funcionarios) {
            if (aux.getNome().equalsIgnoreCase(nome)) {
                return aux;
            }
        }
        return null;
    }

    public void cadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void cadastrarEquipamento(Equipamento e) {
        equipamentos.add(e);
    }

    public Equipamento buscarEquipamento(int id) {
        for (Equipamento aux : equipamentos) {
            if (aux.getId() == id) {
                return aux;
            }
        }
        return null;
    }

    public void editarDescricaoEquipamento(Equipamento e, String novaDescricao) {
        e.setDescricao(novaDescricao);
    }

    public String verificaTipo(String tipoEquipamento) {
        if ("Fixo".equalsIgnoreCase(tipoEquipamento)) {
            return "Equipamento Fixo";
        } else if ("Móvel".equalsIgnoreCase(tipoEquipamento)) {
            return "Equipamento Móvel";
        } else {
            return "Tipo de equipamento não existente!";
        }
    }

    public String verificaDisponibilidade(Equipamento equipamento) {
        return equipamento.getDisponibilidade();
    }
}