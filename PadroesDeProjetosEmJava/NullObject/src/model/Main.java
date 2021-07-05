package model;

public class Main {

    public static void main(String[] args) {
        Produto prod1 = new Produto("Iphone XS", 10000, 3);
        Produto prod2 = new Produto("Notebook Dell I7", 3500, 10);
        Produto prod3 = new Produto("IPad Pro", 5000, 5);

        Item item1 = new Item(prod1, 1, 9000);
        Item item2 = new Item(prod2, 2, 3000);
        Item item3 = new Item(prod3, 1, 4000);

        // Instanciar o carrinho como Carrinho
        Carrinho carrinho = new CarrinhoNulo();
        // Mostra o usuário do carrinho
        System.out.println("Nome do Usuário: "
                + carrinho.getNomeUsuario());
        // Mostra os itens do carrinho
        System.out.println("--- Itens do Carrinho ---");
        for (Item i : carrinho.getItens()){
            System.out.println(i.getProduto().getNome() + 
                    " - " + i.getPrecoUnitario() + 
                    " - " + i.getQuantidade());
        }
        // Mostra o valor total do carrinho
        System.out.println("Valor total do Carrinho: " 
                + carrinho.valorTotal());
        // Testando o HOOK Método
        carrinho.informaDesconto();
        
        System.out.println("-----------------------------");
        // Instancia o carrinho definindo seu dono        
        carrinho = new CarrinhoReal("Fernando");
        // Insere os itens no carrinho
        carrinho.itens.add(item1);
        carrinho.itens.add(item2);
        carrinho.itens.add(item3);
        
        
        // Mostra o nome do dono do carrinho
        System.out.println("Dono do Carrinho: " + 
                carrinho.getNomeUsuario());
        // Mostra os itens do carrinho
        System.out.println("--- Itens do Carrinho ---");
        for (Item i : carrinho.getItens()){
            System.out.println(i.getProduto().getNome() + 
                    " - " + i.getPrecoUnitario() + 
                    " - " + i.getQuantidade());
        }
        // Mostra o valor total do Carrinho
        System.out.println("Valor total do carrinho: " + 
                carrinho.valorTotal());
        // Testando o HOOK Método
        carrinho.informaDesconto();
    }
}
