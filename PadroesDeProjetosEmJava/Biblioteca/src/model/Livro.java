package model;

public class Livro {

    private String titulo;
    private int anoPublic;
    private int edicao;
    private Editora editora;

    public Livro() {
    }   

    public Livro(String titulo, int anoPublic, int edicao, Editora editora) {
        this.titulo = titulo;
        this.anoPublic = anoPublic;
        this.edicao = edicao;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublic() {
        return anoPublic;
    }

    public void setAnoPublic(int anoPublic) {
        this.anoPublic = anoPublic;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
