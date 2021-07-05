package model;

// Classe abstrata, não poderá ter um objeto instanciado com esta classe
import java.util.List;

public abstract class Carrinho {

    // Atributos protegidos
    protected List<Item> itens;
    protected String nomeUsuario;

    // Métodos abstratos
    public abstract List<Item> getItens();
    public abstract String getNomeUsuario();
    public abstract double valorTotal();
    // Método abstrato de exemplo do HOOK Método
    protected abstract double calculaDesconto();
    
    // Método Principal do exemplo HOOK Método
    public void informaDesconto(){
        System.out.println("Calculando o Desconto...");
        // Calcula o desconto - invocar (ou chamar) o HOOK Método
        double desconto = calculaDesconto();
        System.out.println("Total de Desconto: " + desconto);
    }
}
