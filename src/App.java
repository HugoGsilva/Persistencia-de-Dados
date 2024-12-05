import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Escola escola = new Escola("Escola Exemplo", "1234-5678");
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Adicionar Aluno");
                System.out.println("2. Buscar Aluno por Nome");
                System.out.println("3. Buscar Aluno por CPF");
                System.out.println("4. Remover Aluno por CPF");
                System.out.println("5. Listar Alunos");
                System.out.println("6. Adicionar Disciplina");
                System.out.println("7. Buscar Disciplina por Código");
                System.out.println("8. Listar Disciplinas");
                System.out.println("9. Matricular Aluno em Disciplina");
                System.out.println("10. Desmatricular Aluno de Disciplina");
                System.out.println("11. Listar Alunos Matriculados em Disciplina");
                System.out.println("12. Adicionar Professor");
                System.out.println("13. Listar Professores");
                System.out.println("14. Contar Alunos");
                System.out.println("15. Contar Professores");
                System.out.println("16. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite o ano de nascimento: ");
                        int anoNascimento = scanner.nextInt();
                        scanner.nextLine();

                        Aluno novoAluno = new Aluno(nome, cpf, email, anoNascimento);
                        if (escola.adicionar(novoAluno)) {
                            System.out.println("Aluno adicionado com sucesso!");
                        } else {
                            System.out.println("Erro ao adicionar aluno. Verifique se o CPF já está cadastrado.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Digite o nome: ");
                        String nomeBusca = scanner.nextLine();
                        Aluno alunoNome = escola.buscarAluno(nomeBusca);
                        if (alunoNome != null) {
                            System.out.println("Aluno encontrado: " + alunoNome);
                        } else {
                            System.out.println("Aluno não encontrado.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Digite o CPF: ");
                        String cpfBusca = scanner.nextLine();
                        Aluno alunoCpf = escola.buscarAlunoCpf(cpfBusca);
                        if (alunoCpf != null) {
                            System.out.println("Aluno encontrado: " + alunoCpf);
                        } else {
                            System.out.println("Aluno não encontrado.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Digite o CPF do aluno a ser removido: ");
                        String cpfRemover = scanner.nextLine();
                        if (escola.removerAluno(cpfRemover)) {
                            System.out.println("Aluno removido com sucesso!");
                        } else {
                            System.out.println("Erro ao remover aluno. Aluno não encontrado.");
                        }
                    }
                    case 5 -> {
                        System.out.println("Alunos cadastrados:");
                        List<Aluno> alunos = escola.listarAlunos();
                        for (Aluno aluno : alunos) {
                            System.out.println(aluno);
                        }
                    }
                    case 6 -> {
                        System.out.print("Digite o código: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a carga horária: ");
                        int cargaHoraria = scanner.nextInt();
                        System.out.print("Digite o limite de alunos: ");
                        int limiteAlunos = scanner.nextInt();
                        scanner.nextLine();

                        Disciplina novaDisciplina = new Disciplina(codigo, nome, cargaHoraria, limiteAlunos);
                        if (escola.adicionarDisciplina(novaDisciplina)) {
                            System.out.println("Disciplina adicionada com sucesso!");
                        } else {
                            System.out.println("Erro ao adicionar disciplina. Verifique se o código já está cadastrado.");
                        }
                    }
                    case 7 -> {
                        System.out.print("Digite o código: ");
                        String codigoBusca = scanner.nextLine();
                        Disciplina disciplina = escola.buscarDisciplina(codigoBusca);
                        if (disciplina != null) {
                            System.out.println("Disciplina encontrada: " + disciplina);
                        } else {
                            System.out.println("Disciplina não encontrada.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Disciplinas cadastradas:");
                        System.out.println(escola.listarDisciplinas());
                    }
                    case 9 -> {
                        System.out.print("Digite o código da disciplina: ");
                        String codigoDisciplina = scanner.nextLine();
                        System.out.print("Digite o CPF do aluno: ");
                        String cpfAluno = scanner.nextLine();

                        if (escola.matricular(codigoDisciplina, cpfAluno)) {
                            System.out.println("Aluno matriculado com sucesso!");
                        } else {
                            System.out.println("Erro ao matricular aluno. Verifique se o aluno ou a disciplina existe e se há vagas.");
                        }
                    }
                    case 10 -> {
                        System.out.print("Digite o código da disciplina: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Digite o CPF do aluno: ");
                        String cpf = scanner.nextLine();

                        if (escola.desmatricular(codigo, cpf)) {
                            System.out.println("Aluno desmatriculado com sucesso!");
                        } else {
                            System.out.println("Erro ao desmatricular aluno. Verifique se o aluno está matriculado nessa disciplina.");
                        }
                    }
                    case 11 -> {
                        System.out.print("Digite o código da disciplina: ");
                        String codigo = scanner.nextLine();

                        String listaAlunos = escola.listarAlunosMatriculados(codigo);
                        System.out.println(listaAlunos);
                    }
                    case 12 -> {
                        System.out.print("Digite o nome do professor: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite o salário: ");
                        double salario = scanner.nextDouble();
                        System.out.print("Digite a carga horária: ");
                        int cargaHoraria = scanner.nextInt();
                        scanner.nextLine();

                        Professor novoProfessor = new Professor(nome, cpf, email, salario, cargaHoraria);
                        if (escola.adicionar(novoProfessor)) {
                            System.out.println("Professor adicionado com sucesso!");
                        } else {
                            System.out.println("Erro ao adicionar professor. Verifique se o CPF já está cadastrado.");
                        }
                    }
                    case 13 -> {
                        System.out.println("Professores cadastrados:");
                        List<Professor> professores = escola.listarProfessores();
                        for (Professor professor : professores) {
                            System.out.println(professor);
                        }
                    }
                    case 14 -> {
                        int totalAlunos = escola.contarAlunos();
                        System.out.println("Total de alunos cadastrados: " + totalAlunos);
                    }
                    case 15 -> {
                        int totalProfessores = escola.contarProfessores();
                        System.out.println("Total de professores cadastrados: " + totalProfessores);
                    }
                    case 16 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 16);
        }
    }
}
