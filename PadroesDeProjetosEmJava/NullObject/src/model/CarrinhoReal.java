package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoReal extends Carrinho {
    // Métodos Construtores
    public CarrinhoReal(){
        this.itens = new ArrayList<Item>();
    }
    
    public CarrinhoReal(String nomeUsuario){
        this.itens = new ArrayList<Item>();
        this.nomeUsuario = nomeUsuario;
    }
    
    public CarrinhoReal(List<Item> itens, String nomeUsuario){
        this.itens = itens;
        this.nomeUsuario = nomeUsuario;
    }
    
    // Métodos acessores
    @Override
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    // Método que adiciona um novo item no carrinho
    public void addItem(Item item){
        this.itens.add(item);
    }

    @Override
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    // Sobreescreve o método valorTotal()
    @Override
    public double valorTotal(){
        double total = 0;
        // Percorre a lista de itens para definir o valor total
        //for (Item i : this.itens){
        for (Item i : getItens()){
            total += (i.getPrecoUnitario() * i.getQuantidade());            
        }
        return total;
    }
    
    @Override 
    protected double calculaDesconto(){
System.out.println("Verificando se o valor total da compra é maior que R$ 100,00...");
        double desconto = 0;
        if (valorTotal() >= 100){
            System.out.println("Aplicando desconto de 10%...");
            desconto = ((valorTotal() * 10) / 100); // Desconto de 10%
        }
        return desconto;
    }
}
