package modelo;

public class Main {
    public static void main(String[] args) {
        // Cria um sujeito (veículo roubado) que será observado
        VeiculoRoubado veiculoRobado = 
                new VeiculoRoubado("COR-1910", "Monza Tubarão");
        // Adiciona um observador para o sujeito, ou seja, 
        // adiciona as viaturas que irão observar o veículo roubado
        veiculoRobado.addViatura(
                new ViaturaCarro("CRU-2018", "Fiat Toro"));
        veiculoRobado.addViatura(
                new ViaturaMoto("MMM-1234", "XT 660"));
        
        // Iniciar a perseguição... :)
        veiculoRobado.frente();
        System.out.println("");
        veiculoRobado.direita();
        System.out.println("");
        veiculoRobado.frente();
        System.out.println("");
        veiculoRobado.esquerda();
        System.out.println("");
        veiculoRobado.frente();
        System.out.println("");
        veiculoRobado.para();
        System.out.println("");
    }
}
