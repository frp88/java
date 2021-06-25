
import java.sql.*;

public class ConexaoFilme {

    private Connection c = null;//Private vê só dentro da classe
    private Statement s = null;
    private PreparedStatement p = null;

    public int Conecta() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdfilmes", "root", "123456");
            return 0;//retorna 0 quando a conexão dá certo  

        } catch (ClassNotFoundException ce) {//Classe não encontrada retorna 1

            return 1;
        } catch (SQLException sqle) {//Banco de Dados não encontrado retorna 2


            return 2;

        } catch (Exception e) {//Tratamento de algum erro não especificado retorna 3

            return 3;

        }



    }

    public void Desconecta() {

        try {

            c.close();

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

    public boolean insereFilme(String no, String dataE, String dataS, String si) {

        try {
            String sql = "insert into filme(nome, dtEstreia, dtSaida, sinopse) values(?,?,?,?)";
            p = c.prepareStatement(sql);
            p.setString(1, no);
            p.setString(2, dataE);
            p.setString(3, dataS);
            p.setString(4, si);
            p.execute();
            return true;

        } catch (Exception e) {
            System.err.println("Erro de Cadastro");
            return false;
        }
    }

    public boolean atualizaFilme(String n, String dtE, String dtS, String s, int idF) {
        try { //update tblCadAlunos set nome=?, curso=?, periodo=? where matricula=?

            String sql = "update filme set nome=?, dtEstreia=?," +
                    "dtSaida=?, sinopse=? where idFilme=?";
            p = c.prepareStatement(sql);
            p.setString(1, n);
            p.setString(2, dtE);
            p.setString(3, dtS);
            p.setString(4, s);
            p.setInt(5, idF);
            p.execute();
            return true;

        } catch (Exception e) {
            System.err.println("Erro de Atualizaçao!");
            return false;
        }
    }

    public ResultSet buscaFilme(int cod) {
        ResultSet rs = null;
        try {
            s = c.createStatement();
            rs = s.executeQuery("Select nome, dtEstreia, dtSaida, sinopse from filme " +
                    "where idFilme = '" + cod + "'");
            return rs;
        } catch (Exception e) {
            return rs;
        }
    }

    public boolean excluiFilme(int idFilme) {
        try {
            String sql = "delete from filme where idFilme=?";
            p = c.prepareStatement(sql);
            p.setInt(1, idFilme);
            p.execute();
            return true;

        } catch (Exception e) {
            System.err.println("Erro de Exclusão");
            return false;
        }
    }

    public ResultSet buscaFilmesCartaz(String dat) {
        dat += " 00:00:00";
        ResultSet rs = null;
        try {
            s = c.createStatement();
            rs = s.executeQuery("Select idFilme, nome, dtEstreia, dtSaida, sinopse from filme " +
                    "where '" + dat + "' between dtEstreia and dtSaida " +
                    "order by dtEstreia, dtSaida");
            //Select nome, dtEstreia, dtSaida, sinopse from filme where  '2009-01-11 00:00:00' between dtEstreia and dtSaida
            return rs;
        } catch (Exception e) {
            return rs;
        }
    }

    public String formataData(String dt) {
        String dia = dt.substring(0, 2);
        String mes = dt.substring(3, 5);
        String ano = dt.substring(6, 10);
        String novaData = ano + "-" + mes + "-" + dia;
        return novaData;
    }
    public String dataPadraoBrasil(String dt) {
        String ano = dt.substring(0, 4);
        String mes = dt.substring(5, 7);
        String dia = dt.substring(8, 10);
        
        String novaData = dia + "/" + mes + "/" + ano;
        return novaData;
    }
}
