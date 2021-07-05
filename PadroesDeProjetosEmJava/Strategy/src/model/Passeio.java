package model;

public class Passeio extends Veiculo {
    private String tipo; // Sedan, hatch, pick up

    public Passeio() {
        super();
    }

    public Passeio(String marca, String modelo, 
            int anoFabr, String tipo) {
        super(marca, modelo, anoFabr);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
