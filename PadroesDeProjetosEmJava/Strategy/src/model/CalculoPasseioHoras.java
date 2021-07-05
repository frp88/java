package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculoPasseioHoras implements CalculoValor {

    double valorPorHora;

    public CalculoPasseioHoras() {
    }

    public CalculoPasseioHoras(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
    
    // Implementa o método abstrato
    public double calcular(LocalDateTime entrada, LocalDateTime saida){
        // Define o período do estacionamento
        Duration periodo = Duration.between(entrada, saida);
        // Retorna o valor
        return (valorPorHora * periodo.toHours());
    }
}
