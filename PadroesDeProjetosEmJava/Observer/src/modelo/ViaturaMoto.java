package modelo;

public class ViaturaMoto extends Veiculo implements Viatura {

    public ViaturaMoto() {
    }

    public ViaturaMoto(String placa, String modelo) {
        super(placa, modelo);
    }

    // Implementa os métodos abstratos da classe abstrata
    public void frente() {
        System.out.println(" --> Moto siga em frente.");
    }

    public void direita() {
        System.out.println(" --> Moto vire a direita.");
    }

    public void esquerda() {
        System.out.println(" --> Moto vire a esquerda.");
    }

    public void para() {
        System.out.println(" --> Moto pare.");
    }

    // Implementa o método abstrato da interface
    public void atualizaAcao(String acao) {
        System.out.print("Vitura (Moto) placa: "
                + getPlaca());
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
