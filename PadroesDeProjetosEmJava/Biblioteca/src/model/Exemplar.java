package model;

public class Exemplar {
    private Livro livro;
    private String codigo;
    private boolean disponivel;
    private boolean exclusivo;

    public Exemplar() {
    }

    public Exemplar(Livro livro, String codigo, boolean disponivel, boolean exclusivo) {
        this.livro = livro;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.exclusivo = exclusivo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }  
}
