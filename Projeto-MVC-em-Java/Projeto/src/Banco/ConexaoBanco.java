package Banco;

import java.sql.*;

public class ConexaoBanco {

    public Connection con = null;//Private vê só dentro da classe
    public Statement st = null;
    public PreparedStatement pst = null;

    public int conecta() {

        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recurso", "root", "1234");
            //connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
            return 0;//retorna 0 quando a conexão dá certo  

        } catch (ClassNotFoundException ce) {//Classe não encontrada retorna 1

            return 1;
        } catch (SQLException sqle) {//Banco de Dados não encontrado retorna 2

            return 2;

        } catch (Exception e) {//Tratamento de algum erro não especificado retorna 3

            return 3;
        }
    }

    public void desconecta() {

        try {
            con.close();

        } catch (Exception e) {
        }
    }

    public String getMsg(int i) {

        if (i == 1) {
            return "Driver Inexistente";
        }
        if (i == 2) {
            return "Erro nos dados da conexão";
        }
        if (i == 3) {
            return "Erro do sistema";
        } else {
            return "";
        }
    }
}

