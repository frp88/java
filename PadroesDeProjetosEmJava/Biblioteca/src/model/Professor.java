package model;

public class Professor extends Pessoa {
    private String formacao;
    private double salario;

    public Professor() {
        super();
    }

    public Professor(String nome, int idade, String formacao, double salario) {
        super(nome, idade);
        this.formacao = formacao;
        this.salario = salario;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    // Implementa o método abstrato da superclasse
    @Override
    public void bemVindo(){
        System.out.println("Bem vindo senhor professor TOP de linha!");
    }
}
