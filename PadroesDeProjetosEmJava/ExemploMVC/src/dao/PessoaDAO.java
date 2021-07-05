package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pessoa;

public class PessoaDAO {
     // Declaração dos Métodos responsáveis pelo CRUD
    // (Persistência e Recuperação dos dados da tabela no BD
    public String insert(Pessoa pessoa) {
        // Instanciar a conexão com o BD
        Conexao c = new Conexao();
        try {
            c.abreConexao();
            String sql = "INSERT INTO tblpessoa(nome, idade) VALUES('"
                    + pessoa.getNome() + "'," + pessoa.getIdade() + ")";
            c.st = c.con.createStatement();
            c.st.executeUpdate(sql);
            return "Ok";
        } catch (SQLException sqle) {//Banco de Dados não encontrado
            return sqle.toString();
        } catch (Exception e) {//Tratamento de algum erro não especificado
            return e.toString();
        } finally {
            c.fechaConexao();
        }
    }

    public ArrayList<Pessoa> select() {
        // Instanciar um objeto da classe de conexão com BD
        Conexao c = new Conexao();
        try {
            c.abreConexao();
            String sql = "select * from tblpessoa";
            // Instancia uma lista de Pessoas vazia
            ArrayList<Pessoa> lista = new ArrayList<>();
            c.st = c.con.createStatement();
            ResultSet rs = c.st.executeQuery(sql);

            // Enquanto tiver registros --> percorre os registros
            while (rs.next()) {
                // Cria um Objeto do tipo da classe (Pessoa)
                Pessoa p = new Pessoa();
                // Define os valores dos atributos
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                // Adiciona a Pessoa (registro) na Lista
                lista.add(p);
            }
            
            // Retona a lista de pessoas para outra camada
            return lista;

        } catch (SQLException sqle) {//Banco de Dados não encontrado
            //return sqle.toString();
            return null;
        } catch (Exception e) {//Tratamento de algum erro não especificado 
            //return e.toString();
            return null;
        } finally {
            c.fechaConexao();
        }
    }

    public String update(Pessoa pessoa) {
        Conexao c = new Conexao();
        try {
            c.abreConexao();
            String sql = "UPDATE tblpessoa SET nome = '" + pessoa.getNome()
                    + "', idade = " + pessoa.getIdade()
                    + " WHERE idpessoa = " + pessoa.getIdPessoa();
            c.st = c.con.createStatement();
            c.st.executeUpdate(sql);
            return "Ok";
        } catch (SQLException sqle) {//Banco de Dados não encontrado
            return sqle.toString();
        } catch (Exception e) {//Tratamento de algum erro não especificado
            return e.toString();
        } finally {
            c.fechaConexao();
        }
    }

    public String delete(Pessoa pessoa) {
        Conexao c = new Conexao();
        try {
            c.abreConexao();
            String sql = "DELETE FROM tblpessoa "
                    + " WHERE idpessoa = " + pessoa.getIdPessoa();
            c.st = c.con.createStatement();
            c.st.executeUpdate(sql);
            return "Ok";
        } catch (SQLException sqle) {//Banco de Dados não encontrado
            return sqle.toString();
        } catch (Exception e) {//Tratamento de algum erro não especificado
            return e.toString();
        } finally {
            c.fechaConexao();
        }
    }
}
