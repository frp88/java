package modelo;

import java.util.ArrayList;

public class VeiculoRoubado extends Veiculo {

    // Lista de Atributos
    private ArrayList<Viatura> viaturas = new ArrayList<>();
    private String situacao;

    public VeiculoRoubado() {
    }

    public VeiculoRoubado(String placa, String modelo) {
        super(placa, modelo);
    }

    public ArrayList<Viatura> getViaturas() {
        return viaturas;
    }

    public void setViaturas(ArrayList<Viatura> viaturas) {
        this.viaturas = viaturas;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    // Adiciona um novo observador (Viatura)
    public void addViatura(Viatura viatura) {
        this.viaturas.add(viatura);
    }

    // Remove um observador (Viatura)
    public void removeViatura(Viatura viatura) {
        this.viaturas.remove(viatura);
    }

    // Notificar (avisar) os observadores (Viaturas) que o 
    // sujeito (VeiculoRoubado) alterou o valor de um 
    // atributo (atributo "ação)"
    public void notificaViaturas() {
        // Percorre a lista de observadores (Viaturas) 
        // "notificando" cada uma das viaturas
        for (Viatura viatura : viaturas) {
            viatura.atualizaAcao(this.situacao);
        }
    }

    // Implementar os métodos abstratos
    public void frente() {
        System.out.println("Veiculo roubado placa número "
                + getPlaca() + " segue em frente.");
        // Altera a situação do veículo roubado
        this.setSituacao("frente");
        // Avisar (Notificar) os observardores (Viaturas) que 
        // foi alterada a situação do sujeito (VeiculoRoubado)
        this.notificaViaturas();
    }

    public void direita() {
        System.out.println("Veiculo roubado placa número "
                + getPlaca() + " virou à direita.");
        // Altera a situação do veículo roubado
        this.setSituacao("direita");
        // Avisar (Notificar) os observardores (Viaturas) que 
        // foi alterada a situação do sujeito (VeiculoRoubado)
        this.notificaViaturas();
    }

    public void esquerda() {
        System.out.println("Veiculo roubado placa número "
                + getPlaca() + " virou à esqueda.");
        // Altera a situação do veículo roubado
        this.setSituacao("esquerda");
        // Avisar (Notificar) os observardores (Viaturas) que 
        // foi alterada a situação do sujeito (VeiculoRoubado)
        this.notificaViaturas();
    }

    public void para() {
        System.out.println("Veiculo roubado placa número "
                + getPlaca() + " parou.");
        // Altera a situação do veículo roubado
        this.setSituacao("parado");
        // Avisar (Notificar) os observardores (Viaturas) que 
        // foi alterada a situação do sujeito (VeiculoRoubado)
        this.notificaViaturas();
    }

}
