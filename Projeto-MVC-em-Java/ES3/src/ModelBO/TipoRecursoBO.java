package ModelBO;

public class TipoRecursoBO {

    private int IdTipoRecurso;
    private String Descricao;
    private String Observacao;

    public TipoRecursoBO() {
    }

    public TipoRecursoBO(String Descricao, String Observacao) {
        this.setDescricao(Descricao);
        this.setObservacao(Observacao);
    }

    public TipoRecursoBO(int IdTipoRec, String Descricao, String Observacao) {
        this.setIdTipoRecurso(IdTipoRec);
        this.setDescricao(Descricao);
        this.setObservacao(Observacao);
    }

    public int getIdTipoRecurso() {
        return this.IdTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRec) {
        this.IdTipoRecurso = idTipoRec;
    }

    public String getDescricao() {
        return this.Descricao;
    }

    public void setDescricao(String Descricao) {
        if (Descricao.length() >= 100) {
            this.Descricao = Descricao.substring(1, 100);
        } else {
            this.Descricao = Descricao;
        }
    }

    public String getObservacao() {
        return this.Observacao;
    }

    public void setObservacao(String Observacao) {
        if (Observacao.length() >= 100) {
            this.Observacao = Observacao.substring(1, 100);
        } else {
            this.Observacao = Observacao;
        }
    }
}
