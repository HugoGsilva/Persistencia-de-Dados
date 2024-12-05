import java.util.ArrayList;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private int limiteAlunos;
    private ArrayList<Aluno> alunosMatriculados;

    public Disciplina(String codigo, String nome, int cargaHoraria, int limiteAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public boolean matricular(Aluno aluno) {
        if (alunosMatriculados.size() >= limiteAlunos || alunosMatriculados.contains(aluno)) {
            return false;
        }
        alunosMatriculados.add(aluno);
        return true;
    }

    public boolean desmatricular(String cpf) {
        for (Aluno aluno : alunosMatriculados) {
            if (aluno.getCpf().equals(cpf)) {
                alunosMatriculados.remove(aluno);
                return true;
            }
        }
        return false;
    }

    public String listarAlunos() {
        StringBuilder lista = new StringBuilder("Alunos Matriculados:\n");
        for (Aluno aluno : alunosMatriculados) {
            lista.append(aluno).append("\n");
        }
        return lista.toString();
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Carga Horária: " + cargaHoraria;
    }
}
