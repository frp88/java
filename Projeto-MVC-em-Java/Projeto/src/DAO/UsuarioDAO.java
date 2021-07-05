package DAO;

import java.sql.*;
import Banco.ConexaoBanco;
import ModelBO.UsuarioBO;
import ModelBO.TipoUsuario;
import ModelBO.StatusDeUsuario;

public class UsuarioDAO {

    public boolean insereUser(UsuarioBO user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "insert into tblusuario(sidusuario, ssenha, snome, nstatus, ntipo) values(?,?,?,?,?)";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user.getIdUsuario());
            c.pst.setString(2, user.getSenha());
            c.pst.setString(3, user.getNome());
            c.pst.setInt(4, 0);
            c.pst.setInt(5, user.codTipoUser(user.getTipoUsuario()));
            c.pst.execute();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateUser(UsuarioBO user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "update tblusuario set sSenha = ?, sNome = ?, nStatus = ?, nTipo = ? where sIdUsuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user.getSenha());
            c.pst.setString(2, user.getNome());
            c.pst.setInt(3, user.codStatusUser(user.getStatus()));
            c.pst.setInt(4, user.codTipoUser(user.getTipoUsuario()));
            c.pst.setString(5, user.getIdUsuario());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteUser(UsuarioBO user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "delete tblusuario where sIdUsuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user.getIdUsuario());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UsuarioBO buscaUser(String idUsuario) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblusuario where sidusuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, idUsuario);
            UsuarioBO userAux = new UsuarioBO();
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                UsuarioBO user = new UsuarioBO(rs.getString("sIdUsuario"), rs.getString("sSenha"), rs.getString("sNome"), userAux.StatusUser(rs.getInt("nStatus")), userAux.TipoUser(rs.getInt("nTipo")));
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public int buscaTipoUser(String idUsuario) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblusuario where sidusuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, idUsuario);
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("ntipo");
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public Boolean verificaIdUser(String user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblusuario where sidusuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user);
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verificaIdUserSenha(UsuarioBO user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "select * from tblusuario where sidusuario = ? and ssenha = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user.getIdUsuario());
            c.pst.setString(2, user.getSenha());
            ResultSet rs = c.pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean bloqueiaUser(UsuarioBO user) {
        try {
            ConexaoBanco c = new ConexaoBanco();
            c.conecta();
            String sql = "update tblusuario set nStatus = 1 where sIdUsuario = ?";
            c.pst = c.con.prepareStatement(sql);
            c.pst.setString(1, user.getIdUsuario());
            c.pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
