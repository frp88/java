package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoNulo extends Carrinho {
    // Implementando os Métodos abstratos
    @Override
    public List<Item> getItens() {
        // Retorna uma nova lista vazia
        return new ArrayList<Item>();
    }

    @Override
    public String getNomeUsuario() {
        return "Usuário não definido";
    }

    @Override
    public double valorTotal() {
        return 0;
    }
    @Override
    protected double calculaDesconto(){
        System.out.println("O carrinho vazio não tem desconto.");
        return 0;
    }
}
