package modelo;

public class ViaturaCarro extends Veiculo implements Viatura {

    public ViaturaCarro() {
    }

    public ViaturaCarro(String placa, String modelo) {
        super(placa, modelo);
    }

    // Implementa os métodos abstratos 
    // da classe abstrata "Veiculo"
    public void frente() {
        System.out.println(" --> Carro siga em frente.");
    }

    public void direita() {
        System.out.println(" --> Carro vire à direita.");
    }

    public void esquerda() {
        System.out.println(" --> Carro vire à esquerda.");
    }

    public void para() {
        System.out.println(" --> Carro pare.");
    }

    // Implementa os métodos abstratos da 
    // interface "Viatura"
    public void atualizaAcao(String acao) {
        System.out.print("Viatura (Carro) placa: "
                + getPlaca());
        // Verifica qual a ação a viatura deverá realizar
        switch (acao) {
            case "direita":
                this.direita();
                break;
            case "esquerda":
                this.esquerda();
                break;
            case "frente":
                this.frente();
                break;
            default:
                this.para();
                break;
        }
    }
}
