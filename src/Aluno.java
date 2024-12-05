public class Aluno extends Pessoa {
    private int anoNascimento;

    public Aluno(String nome, String cpf, String email, int anoNascimento) {
        super(nome, cpf, email);
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Ano de Nascimento: " + anoNascimento;
    }
}
