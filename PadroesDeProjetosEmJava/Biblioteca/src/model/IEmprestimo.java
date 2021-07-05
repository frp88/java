package model;

public interface IEmprestimo {    
    // Todos os atributos constantes
    //int qtdLivrosPorEmprestimo = 3;
    public static final int qtdLivrosPorEmprestimo = 3;
    // Todos os método são abstratos
    public abstract void addExemplar(Exemplar exemplar);
    public abstract boolean devolverLivros();
    public abstract void definirDataDeDevolucao();
}
