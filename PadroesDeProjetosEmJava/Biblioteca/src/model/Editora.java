package model;

public class Editora extends Pessoa {

    private String cnpj;

    public Editora() {
        super();
    }

    public Editora(String nome, int idade, String cnpj) {
        super(nome, idade);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void bemVindo() {
        System.out.println("Prezada editora, seja bem vinda.");
    }
}
