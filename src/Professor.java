public class Professor extends Pessoa {
    private double salario;
    private int cargaHoraria;

    public Professor(String nome, String cpf, String email, double salario, int cargaHoraria) {
        super(nome, cpf, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
  
    public int getCargaHoraria() {
        return cargaHoraria;
    }
  
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Salário: " + salario + ", Carga Horária: " + cargaHoraria;
    }
}
