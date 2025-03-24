public class Funcionario {
    private String matricula;
    private String nome;
    private String email;

    public Funcionario(String matricula, String nome, String email) {
        this.matricula = "101" + matricula.trim();
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
}
