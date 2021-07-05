package modelo;

public abstract class Veiculo {

    private String placa;
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    // Define os métodos abstratos
    public abstract void frente();
    
    public abstract void direita();
    
    public abstract void esquerda();
    
    public abstract void para();
    
}
