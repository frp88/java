package model;

import java.time.LocalDateTime;

public interface CalculoValor {
    // Assinatura do método abstrato
    double calcular(LocalDateTime entrada, LocalDateTime saida);
}
