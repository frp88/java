package ControlUC;

import ModelBO.UsuarioBO;
import ModelBO.StatusDeUsuario;
import ModelBO.TipoUsuario;
import DAO.UsuarioDAO;

public class UsuarioUC {

    public static int chances = 3;
    public static int tUsuario;
    public static String ultUsuario = null;

    public String cadastraUsuario(String idUsuario, String senha, String nome, String tipo) {
        try {
            if (verificaLogin(idUsuario) == "Usuario não cadastrado!") {
                UsuarioBO userBO = new UsuarioBO(idUsuario, senha, nome, StatusDeUsuario.ativo, TipoUsuario.valueOf(tipo));
                UsuarioDAO userDAO = new UsuarioDAO();
                if (userDAO.insereUser(userBO)) {
                    return "Usuario Cadastrado com Sucesso!";
                } else {
                    return "Cadastro não Realizado!";
                }
            } else {
                return verificaLogin(idUsuario);
            }
        } catch (Exception e) {
            return "Erro de Cadastro";
        }
    }

    public String verificaLogin(String idUsuario) {
        try {
            UsuarioDAO userDAO = new UsuarioDAO();
            if (!userDAO.verificaIdUser(idUsuario)) {
                return "Usuario não cadastrado!";
            }
            return "Usuario existente";
        } catch (Exception e) {
            return "Erro na consulta!";
        }
    }

    public String verificaLoginSenha(String idUsuario, String senha) {
        try {
            UsuarioBO userBO = new UsuarioBO();
            userBO.setIdUsuario(idUsuario);
            userBO.setSenha(senha);
            UsuarioDAO userDAO = new UsuarioDAO();
            if (userDAO.verificaIdUser(idUsuario)) {
                UsuarioBO uu = userDAO.buscaUser(idUsuario);
                if (uu.getStatus() == StatusDeUsuario.ativo) {
                    if (!idUsuario.equals(ultUsuario)) {
                        chances = 3;
                    }
                    ultUsuario = idUsuario;
                    if (!userDAO.verificaIdUserSenha(userBO)) {
                        chances--;
                        if (chances > 0) {
                            return "Usuario ou Senha Inválidos!\nVocê tem mais " + chances + " chances!";
                        } else {
                            userBO.desativa();
                            userDAO.bloqueiaUser(userBO);
                            return "Seu usuario foi bloqueado!";
                        }
                    }
                } else {
                    return "Usuario bloqueado!";
                }
            } else {
                chances = 3;
                return "Usuario não cadastrado!";
            }
            tUsuario = pegaTipoUsuario(idUsuario);
            return "Usuario ok";
        } catch (Exception e) {
            return "Erro na consulta!";
        }
    }

    public int pegaTipoUsuario(String idUsuario) {
        try {
            UsuarioDAO userDAO = new UsuarioDAO();
            return userDAO.buscaTipoUser(idUsuario);
        } catch (Exception e) {
            return -1;
        }
    }
}
