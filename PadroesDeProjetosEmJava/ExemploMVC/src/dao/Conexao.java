package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    // Variáveis Globais
    public Connection con = null;
    public Statement st = null;

    public String abreConexao() {
        try {
            // CONFIGURAÇÃO DO MYSQL
            //Class.forName("org.gjt.mm.mysql.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdexemplo", "root", "123456");

            // CONFIGURAÇÃO DO MARIADB
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost/bdexemplo", "root", "");

            return "Ok";//retorna 0 quando a conexão dá certo  

        } catch (ClassNotFoundException ce) {//Classe não encontrada 
            return ce.toString();
        } catch (SQLException sqle) {//Banco de Dados não encontrado 
            return sqle.toString();

        } catch (Exception e) {//Tratamento de algum erro não especificado 
            return e.toString();
        }
    }

    public void fechaConexao() {
        try {
            con.close();
        } catch (Exception e) {
        }
    }
}
