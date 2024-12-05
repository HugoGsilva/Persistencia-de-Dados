import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private String telefone;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public boolean adicionar(Aluno aluno) {
        if (buscarPessoaPorCpf(aluno.getCpf()) != null) {
            return false;
        }
        alunos.add(aluno);
        return true;
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno buscarAlunoCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public boolean removerAluno(String cpf) {
        Aluno aluno = buscarAlunoCpf(cpf);
        if (aluno != null) {
            alunos.remove(aluno);
            return true;
        }
        return false;
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    public int contarAlunos() {
        return alunos.size();
    }

    public boolean adicionar(Professor professor) {
        if (buscarPessoaPorCpf(professor.getCpf()) != null) {
            return false;
        }
        professores.add(professor);
        return true;
    }

    public Professor buscarProfessorCpf(String cpf) {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        return null;
    }

    public List<Professor> listarProfessores() {
        return new ArrayList<>(professores);
    }

    public int contarProfessores() {
        return professores.size();
    }

    private Pessoa buscarPessoaPorCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        return null;
    }

    public boolean adicionarDisciplina(Disciplina disciplina) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(disciplina.getCodigo())) {
                return false;
            }
        }
        disciplinas.add(disciplina);
        return true;
    }

    public Disciplina buscarDisciplina(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    public String listarDisciplinas() {
        StringBuilder sb = new StringBuilder();
        for (Disciplina disciplina : disciplinas) {
            sb.append(disciplina).append("\n");
        }
        return sb.toString();
    }

    public boolean matricular(String codigoDisciplina, String cpfAluno) {
        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        Aluno aluno = buscarAlunoCpf(cpfAluno);
        if (disciplina != null && aluno != null) {
            return disciplina.matricular(aluno);
        }
        return false;
    }

    public boolean desmatricular(String codigoDisciplina, String cpfAluno) {
        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        if (disciplina != null) {
            return disciplina.desmatricular(cpfAluno);
        }
        return false;
    }

    public String listarAlunosMatriculados(String codigoDisciplina) {
        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        if (disciplina != null) {
            return disciplina.listarAlunos();
        }
        return "Disciplina não encontrada.";
    }
}
