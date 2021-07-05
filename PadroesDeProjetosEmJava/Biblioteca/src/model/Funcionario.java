package model;

// Exemplo de Herança Múltipla em Java
public class Funcionario extends Pessoa 
        implements HorarioDeTrabalho {
    String horaEntrada;
    String horaSaida;
    float salario;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, int idade, String horaEntrada, String horaSaida, float salario) {
        super(nome, idade);
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.salario = salario;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
       
    // Implementando os métodos abstratos
    @Override
    public void bemVindo(){
        System.out.println("Bem vindo querido funcionário.");
    }
    
    @Override
    public void definirHorario(){
        this.setHoraEntrada("08:00");
        this.setHoraSaida("17:00");
    }
}
