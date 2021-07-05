package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculoCargaDiaria implements CalculoValor {

    private double valorDiaria;

    public CalculoCargaDiaria() {
    }

    public CalculoCargaDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    // Implementa o método abstrato
    public double calcular(LocalDateTime entrada, LocalDateTime saida){
        // Pega a duração da locação
        Duration periodo = Duration.between(entrada, saida);
        // retorna o valor da locação
        return (valorDiaria * periodo.toDays());
    }
}
