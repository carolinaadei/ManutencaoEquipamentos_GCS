public class Funcionario {
    private static int contadorMatricula = 101;
    private int matricula;
    private String nome;
    private String email;

    public Funcionario(String nome, String email) {
        this.matricula = contadorMatricula++;
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}