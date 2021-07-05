package model;

// Classe que calcula o valor período estacionado 
import java.time.Duration;
import java.time.LocalDateTime;

// de um veículo de passeio que ficou mais de 24 horas
public class CalculoPasseioDiaria implements CalculoValor {

    private double valorDiaria;

    public CalculoPasseioDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public CalculoPasseioDiaria() {
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    // Implementa o método abstrato
    public double calcular(LocalDateTime entrada, LocalDateTime saida) {
        // Período estacionado
        Duration periodo = Duration.between(entrada, saida);
        // Define a quantidade de dias estacionado
        long dias = periodo.toDays();
        // Retorna o valor a ser pago
        return (dias * valorDiaria);
    }
}
