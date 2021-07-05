package model;

// Herdar da classe Pessoa
public class Aluno extends Pessoa{
    private int matricula;
    private String curso;
    
    // Métodos Construtores
    public Aluno(){
        // Chama o método construtor da superclasse
        super();
    }
    public Aluno(String nome, int idade, 
            int matricula, String curso){
        super(nome, idade);
        this.matricula = matricula;
        this.curso = curso;
    }
    
    // Métodos acessores
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }  
    
    // Implementando o método abstrato
    @Override
    public void bemVindo(){
        System.out.println("E aí aluno, seja bem vindo!!! :-)");
    }    
}
