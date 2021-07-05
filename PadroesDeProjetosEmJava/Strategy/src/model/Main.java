package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto passeio
        Veiculo veiculo1 = new Passeio("Volks", "Gol", 2018, "Hatch");
        
        // Define a conta de estacionamento
        ContaEstacionamento conta = 
                new ContaEstacionamento(veiculo1);
        // Define a entrada e a saída
        LocalDateTime entrada = 
                LocalDateTime.of(2018, 8, 30, 10, 30);
        LocalDateTime saida = LocalDateTime.now();
        conta.setEntrada(entrada);
        conta.setSaida(saida);
        
        //Define o cálculo que será realizado
        CalculoValor calculo = new CalculoPasseioHoras(3);
        
        // Atribui o cálculo à conta 
        conta.setCalculo(calculo);
        
        // Recebe o valor total da locação
        double valor = conta.valorConta();
        // Imprime na tela o valor total da locação
        System.out.println("Valor total da locação: " + 
                valor);       
        
        // Altera a data de entrada
        entrada = LocalDateTime.of(2018, 8, 27, 15, 40);
        conta.setEntrada(entrada);
        
        // altera o cáculo da locação
        calculo = new CalculoPasseioDiaria(40);
        conta.setCalculo(calculo);
        // Recebe o novo valor da locação
        valor = conta.valorConta();
        // Imprime o valor da locação
        System.out.println("Valor locação (diária): " + valor);
        
        // Alterando o veículo da locação existente
        veiculo1 = 
                new Carga("Volvo", "FH16", 2015, 3, 5000, 20);
        // Altera o cálculo em tempo de execução
        calculo = new CalculoCargaDiaria(200);
        conta.setCalculo(calculo);
        // pega o valor total 
        valor = conta.valorConta();
        System.out.println("Valor total da locação da Carga: " + 
                valor);
        
        
    }
}
