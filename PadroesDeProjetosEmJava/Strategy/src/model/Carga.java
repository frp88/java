package model;

public class Carga  extends Veiculo{
    private int nroEixos;
    private double valorCarga;
    private double comprimento;

    public Carga() {
        super();
    }

    public Carga(String marca, String modelo, int anoFabr, 
            int nroEixos, double valorCarga, double comprimento) {
        super(marca, modelo, anoFabr);
        this.nroEixos = nroEixos;
        this.valorCarga = valorCarga;
        this.comprimento = comprimento;
    }

    public int getNroEixos() {
        return nroEixos;
    }

    public void setNroEixos(int nroEixos) {
        this.nroEixos = nroEixos;
    }

    public double getValorCarga() {
        return valorCarga;
    }

    public void setValorCarga(double valorCarga) {
        this.valorCarga = valorCarga;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    
}
