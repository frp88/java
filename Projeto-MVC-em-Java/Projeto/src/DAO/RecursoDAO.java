package DAO;

import java.sql.*;
import Banco.ConexaoBanco;
import ModelBO.RecursoBO;
import DAO.TipoRecursoDAO;
import ModelBO.StatusDoRecurso;

public class RecursoDAO {

    public boolean insereRecurso(RecursoBO rec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "insert into tblrecurso(nIdTipoRecurso, sDescricao, sLocal, nStatus) values (?, ?, ?, ?)";
            TipoRecursoDAO tr = new TipoRecursoDAO();
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, rec.getTipoRecurso().getIdTipoRecurso());
            c.pst.setString(2, rec.getDescricao());
            c.pst.setString(3, rec.getLocalizacao());
            c.pst.setInt(4, 0);
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateRecurso(RecursoBO rec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "update tblrecurso set sDescricao = ?, sLocal = ?, nStatus = ? where nIdRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, rec.getDescricao());
            c.pst.setString(2, rec.getLocalizacao());
            c.pst.setInt(3, rec.codStatusRec(rec.getStatusRecurso()));
            c.pst.setInt(4, rec.getIdRecurso());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteRecurso(RecursoBO rec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "delete tblrecurso where nIdRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, rec.getIdRecurso());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet buscaRecurso() {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblrecurso order by sDescricao";
            c.pst = c.con.prepareStatement(sql);
            ResultSet rs = c.pst.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public RecursoBO buscaRecursoPorDesc(String descRecurso) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblRecurso where sDescricao = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, descRecurso);
            ResultSet rs = c.pst.executeQuery();
            TipoRecursoDAO tRec = new TipoRecursoDAO();

            RecursoBO recAux = new RecursoBO();
            if (rs.next()) {
                RecursoBO rec = new RecursoBO(tRec.buscaTipoRecursoPorId(rs.getInt("nIdTipoRecurso")), rs.getString("sDescricao"), rs.getString("sLocal"), recAux.StatusRec(rs.getInt("nStatus")));
                return rec;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }
     public RecursoBO buscaRecursoPorId(int idRec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblRecurso where nIdRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, idRec);
            ResultSet rs = c.pst.executeQuery();
            TipoRecursoDAO tRec = new TipoRecursoDAO();

            RecursoBO recAux = new RecursoBO();
            if (rs.next()) {
                RecursoBO rec = new RecursoBO(tRec.buscaTipoRecursoPorId(rs.getInt("nIdTipoRecurso")), rs.getString("sDescricao"), rs.getString("sLocal"), recAux.StatusRec(rs.getInt("nStatus")));
                return rec;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
