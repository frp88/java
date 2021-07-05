package DAO;

import java.sql.*;
import Banco.ConexaoBanco;
import ModelBO.TipoRecursoBO;

public class TipoRecursoDAO {

    public boolean insereTipoRecurso(TipoRecursoBO tRec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "insert into tbltiporecurso(sDescricao, sObs) values (?, ?)";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, tRec.getDescricao());
            c.pst.setString(2, tRec.getObservacao());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateTipoRecurso(TipoRecursoBO tRec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "update tbltiporecurso set sDescricao = ? , sObs = ? where nIdTipoRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, tRec.getDescricao());
            c.pst.setString(2, tRec.getObservacao());
            c.pst.setInt(3, tRec.getIdTipoRecurso());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteTipoRecurso(TipoRecursoBO tRec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "delete tbltiporecurso where nIdTipoRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(3, tRec.getIdTipoRecurso());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet buscaTipoRecurso() {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tbltiporecurso order by sDescricao";
            c.pst = c.con.prepareStatement(sql);
            ResultSet rs = c.pst.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public TipoRecursoBO buscaTipoRecursoPorDesc(String descRecurso) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblTipoRecurso where sDescricao = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, descRecurso);
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                TipoRecursoBO tRec = new TipoRecursoBO(rs.getInt("nIdTipoRecurso"), rs.getString("sDescricao"), rs.getString("sObs"));
                return tRec;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public TipoRecursoBO buscaTipoRecursoPorId(int idRec) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblTipoRecurso where nIdTipoRecurso = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setInt(1, idRec);
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                TipoRecursoBO tRec = new TipoRecursoBO(rs.getInt("nIdTipoRecurso"), rs.getString("sDescricao"), rs.getString("sObs"));
                return tRec;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
