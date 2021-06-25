package ControlUC;

import ModelBO.RecursoBO;
import ModelBO.TipoRecursoBO;
import DAO.RecursoDAO;
import DAO.TipoRecursoDAO;

public class RecursoUC {

    public String cadastraRecurso(String tipoRec, String descricao, String local) {
        try {
            TipoRecursoDAO tipoRecDAO = new TipoRecursoDAO();
            TipoRecursoBO tipoRecBO = new TipoRecursoBO();
            //busca o IDTipoRecurso passando como parametro a descricao do recurso
            tipoRecBO = tipoRecDAO.buscaTipoRecursoPorDesc(tipoRec);
            RecursoBO recBO = new RecursoBO(tipoRecBO, descricao.toUpperCase(), local.toUpperCase());
            RecursoDAO recDAO = new RecursoDAO();
            if (recDAO.buscaRecursoPorDesc(recBO.getDescricao()) == null) {
                if (recDAO.insereRecurso(recBO)) {
                    return "Recurso Cadastrado com Sucesso!";
                } else {
                    return "Recurso não Cadastrado!";
                }
            } else {
                return "Recurso já Cadastrado!";
            }

        } catch (Exception e) {
            return "Erro de Cadastro!";
        }
    }
}
