package model;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabr;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, int anoFabr) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabr = anoFabr;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabr() {
        return anoFabr;
    }

    public void setAnoFabr(int anoFabr) {
        this.anoFabr = anoFabr;
    }
    
    
    
}
