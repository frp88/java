package DAO;

import java.sql.*;
import Banco.ConexaoBanco;
import ModelBO.AgendamentoBO;
import ModelBO.StatusDoAgendamento;
import DAO.RecursoDAO;
import DAO.UsuarioDAO;

public class AgendamentoDAO {

    public boolean insereAgendamento(AgendamentoBO ag) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "insert into tblagendamento(nIdRecurso, sIdUsuario, nStatus, sPredio, sSala, " +
                    "nDuracao, dAgendamento, sObs) valeus(?,?,?,?,?,?,?,?)";
            UsuarioDAO user = new UsuarioDAO();
            RecursoDAO rec = new RecursoDAO();
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, ag.getRecurso().getIdRecurso());
            c.pst.setString(2, ag.getUsuario().getIdUsuario());
            c.pst.setInt(3, ag.codStatusAg(ag.getStatusDoAgendamento()));
            c.pst.setString(4, ag.getPredio());
            c.pst.setString(5, ag.getSala());
            c.pst.setDouble(6, ag.getDuracao());
            c.pst.setDate(7, (Date) ag.getDtAgendamento());
            c.pst.setString(8, ag.getObservacao());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateAgendamento(AgendamentoBO ag) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "update tblagendamento set nStatus = ?, dtEmprestimo = ?, dDevolucao = ?, sObs = ? where nIdAgendamento = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, ag.codStatusAg(ag.getStatusDoAgendamento()));
            c.pst.setDate(2, (Date) ag.getDtEmprestimo());
            c.pst.setString(4, ag.getObservacao());
            c.pst.setInt(5, ag.getIdAgendamento());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet buscaAgendamento() {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblagendamento";
            c.pst = c.con.prepareStatement(sql);
            ResultSet rs = c.pst.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }
}

