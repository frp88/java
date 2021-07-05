package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    // Lista de atributos
    private String nome;
    private int idade;
    private List<Telefone> telefones;

    // Metodos Construtores
    public Pessoa() {
        // Cria a lista vazia
        telefones = new ArrayList<Telefone>();
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        // Cria a lista vazia
        telefones = new ArrayList<Telefone>();
    }

    // Métodos acessores
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    // Não existe o método setTelefones()
    public void addTelefone(String numero, String tipo) {
        // Cria um objeto do telefone
        Telefone tel = new Telefone(numero, tipo, this);
        // Adiciona o telefone na lista 
        telefones.add(tel);
    }

    // Remove um telefone
    public void removeTelefone(Telefone tel) {
        telefones.remove(tel);
    }

    // Assinatura do método abstrato
    public abstract void bemVindo();

    // Classe Telefone - exemplo de composição
    public class Telefone {

        private String numero;
        private String tipo;
        // Define o dono do telefone
        private Pessoa dono;

        // Os métodos construtores da classe interna 
        // obrigatoriamente são privados!!!
        private Telefone() {
        }

        private Telefone(String numero, String tipo, Pessoa dono) {
            this.numero = numero;
            this.tipo = tipo;
            this.dono = dono;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public Pessoa getDono() {
            return dono;
        }
        // Não implementa o método setDono()      
    }
}
