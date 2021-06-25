package ModelBO;

import java.sql.Time;
import java.util.Date;

public class AgendamentoBO {

    private int idAgendamento;
    private RecursoBO Recurso;
    private UsuarioBO Usuario;
    private StatusDoAgendamento Status;
    private String Predio;
    private String Sala;
    private double Duracao;
    private Date dtAgendamento;
    private Date dtEmprestimo;
    private Date dtDevolucao;
    private String Observacao;

    public AgendamentoBO() {
    }

    public int getIdAgendamento() {
        return this.idAgendamento;
    }

    public RecursoBO getRecurso() {
        return this.Recurso;
    }

    public void setRecurso(RecursoBO Recurso) {
        this.Recurso = Recurso;
    }

    public UsuarioBO getUsuario() {
        return this.Usuario;
    }

    public void setUsuario(UsuarioBO Usuario) {
        this.Usuario = Usuario;
    }

    public String getPredio() {
        return this.Predio;
    }

    public void setPredio(String predio) {
        this.Predio = predio;
    }

    public String getSala() {
        return this.Sala;
    }

    public void setSala(String sala) {
        this.Sala = sala;
    }

    public double getDuracao() {
        return this.Duracao;
    }

    public void setDuracao(double duracao) {
        this.Duracao = duracao;
    }

    public Date getDtAgendamento() {
        return this.dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public Date getDtEmprestimo() {
        return this.dtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public Date getDtDevolucao() {
        return this.dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public String getObservacao() {
        return this.Observacao;
    }

    public void setObservacao(String observacao) {
        this.Observacao = observacao;
    }

    public StatusDoAgendamento getStatusDoAgendamento() {

        return this.Status;
    }

    public void setStatusDoAgendamento(StatusDoAgendamento status) {
        this.Status = status;
    }

    public StatusDoAgendamento StatusAg(int codStatus) {
        try {
            StatusDoAgendamento st = null;
            switch (codStatus) {
                case 0:
                    st = Status.agendado;
                    break;
                case 1:
                    st = Status.concluido;
                    break;
                case 2:
                    st = Status.cancelado;
                    break;
                case 3:
                    st = Status.naoAgendado;
                    break;
                default:
                    break;
            }
            return st;
        } catch (Exception e) {
            return null;
        }
    }

    public int codStatusAg(StatusDoAgendamento status) {
        try {
            int tipo = -1;
            switch (status) {
                case agendado:
                    tipo = 0;
                    break;
                case concluido:
                    tipo = 1;
                    break;
                case cancelado:
                    tipo = 2;
                    break;
                case naoAgendado:
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
