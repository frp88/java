package ModelBO;

public class RecursoBO {

    private int IdRecurso;
    private TipoRecursoBO tipoRecurso;
    private String Descricao;
    private String Localizacao;
    private StatusDoRecurso status;

    public RecursoBO() {
    }

    public RecursoBO(TipoRecursoBO tipoRecurso, String Descricao, String Local) {
        this.setTipoRecurso(tipoRecurso);
        this.setDescricao(Descricao);
        this.setLocalizacao(Local);
    }

    public RecursoBO(TipoRecursoBO tipoRecurso, String Descricao, String Local, StatusDoRecurso statusRec) {
        this.setTipoRecurso(tipoRecurso);
        this.setDescricao(Descricao);
        this.setLocalizacao(Local);
        this.setStatusRecurso(statusRec);
    }

    public int getIdRecurso() {
        return this.IdRecurso;
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

    public String getLocalizacao() {
        return this.Localizacao;
    }

    public void setLocalizacao(String Localizacao) {
        if (Localizacao.length() >= 100) {
            this.Localizacao = Localizacao.substring(1, 100);
        } else {
            this.Localizacao = Localizacao;
        }
    }

    public TipoRecursoBO getTipoRecurso() {
        return this.tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoBO tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public StatusDoRecurso getStatusRecurso() {
        return this.status;
    }

    public void setStatusRecurso(StatusDoRecurso statusRecurso) {
        this.status = statusRecurso;
    }

    public StatusDoRecurso StatusRec(int codStatusRec) {
        try {
            StatusDoRecurso st = null;
            switch (codStatusRec) {
                case 0:
                    st = status.disponivel;
                    break;
                case 1:
                    st = status.solicitado;
                    break;
                case 2:
                    st = status.emprestado;
                    break;
                case 3:
                    st = status.manutencao;
                    break;
                default:
                    break;
            }

            return st;
        } catch (Exception e) {
            return null;
        }
    }

    public int codStatusRec(StatusDoRecurso status) {
        try {
            int tipo = -1;
            switch (status) {
                case disponivel:
                    tipo = 0;
                    break;
                case solicitado:
                    tipo = 1;
                    break;
                case emprestado:
                    tipo = 2;
                    break;
                case manutencao:
                    tipo = 3;
                    break;
                default:
                    break;
            }
            return tipo;
        } catch (Exception e) {
            return -1;
        }
    }
}
