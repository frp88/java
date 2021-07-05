package model;

import java.time.LocalDateTime;

public class ContaEstacionamento {
    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorTotal;
    // Atributo da interface CalculoValor
    private CalculoValor calculo;

    public ContaEstacionamento() {
    }

    public ContaEstacionamento(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ContaEstacionamento(Veiculo veiculo, LocalDateTime entrada) {
        this.veiculo = veiculo;
        this.entrada = entrada;
    }

    public ContaEstacionamento(Veiculo veiculo, LocalDateTime entrada, 
            LocalDateTime saida, CalculoValor calculo) {
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.calculo = calculo;
        // Definir o valor total
        this.valorTotal= calculo.calcular(entrada, saida);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
    
    // Não implementa o método getCalculo()
    
    // Altera o cálculo
    public void setCalculo(CalculoValor calculo){
        this.calculo = calculo;
    }
    
    // Método que retorna o valor total
    public double valorConta(){
        // Retorna o cálculo realizado de acordo com o tipo 
        // que foi instanciado o atributo "calculo"
        return calculo.calcular(entrada, saida);
    }
    
    public double getValorTotal(){
        return valorTotal;
    }
    
    public void setValorTotal(){
        // Chama o método que calcula o valor da locação
        this.valorTotal = calculo.calcular(entrada, saida);        
    }
}
