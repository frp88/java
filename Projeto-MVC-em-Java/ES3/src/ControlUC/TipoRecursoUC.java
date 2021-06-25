package ControlUC;

import ModelBO.TipoRecursoBO;
import DAO.TipoRecursoDAO;
import java.sql.*;

public class TipoRecursoUC {

    public String cadastraTipoRecurso(String descricao, String obs) {
        try {
            TipoRecursoBO tRecBO = new TipoRecursoBO(descricao.toUpperCase(), obs.toUpperCase());
            TipoRecursoDAO tRecDAO = new TipoRecursoDAO();
            if (tRecDAO.buscaTipoRecursoPorDesc(tRecBO.getDescricao()) == null) {
                if (tRecDAO.insereTipoRecurso(tRecBO)) {
                    return "Tipo Recurso Cadastrado com Sucesso!";
                } else {
                    return "Tipo de Recurso não Cadastrado!";
                }
            } else {
                return "Tipo de Recusro já Cadastrado!";
            }
        } catch (Exception e) {
            return "Erro de Cadastro!";
        }
    }

    public ResultSet pegaTipoRecurso() {
        try {
            TipoRecursoDAO tRecDAO = new TipoRecursoDAO();

            return tRecDAO.buscaTipoRecurso();
        } catch (Exception e) {
            return null;
        }
    }
}
