package controller;

import dao.PessoaDAO;
import model.Pessoa;
import java.util.ArrayList;

public class PessoaController {
    // Cadastrar Pessoa
    public String cadastraPessoa(String nome, int idade){
        // Instanciar um objeto do Modelo (Pessoa)
        Pessoa pessoa = new Pessoa(nome, idade);
        // Instanciar um objeto da camada DAO (PessoaDAO)
        PessoaDAO pessoaDAO = new PessoaDAO();
        // Salva este objeto no BD
        String resultado = pessoaDAO.insert(pessoa);
        if (resultado.equalsIgnoreCase("Ok")){
            return "Pessoa cadastrada com sucesso!";
        }
        else{
            return "Erro: " + resultado;
        }
    }
    // Buscar Pessoas
    public ArrayList<Pessoa> buscaPessoas(){
        // Instancia um objeto da camada DAO (PessoaDAO)
        PessoaDAO pessoa = new PessoaDAO();
        // Retorna para outra camada todas as pessoas
        // armazenadas na tabela referente a este modelo
        return pessoa.select();
    }
    
    // Alterar Pessoa
    public String atualizaPessoa(int idPessoa, String nome, int idade){
        // Instancia um objeto do Modelo (Pessoa)
        Pessoa pessoa = new Pessoa(idPessoa, nome, idade);
        // Instancia um objeto da camada DAO (PessoaDAO)
        PessoaDAO pessoaDAO = new PessoaDAO();
        // Salva as alterações desta pessoa no BD
        String resultado = pessoaDAO.update(pessoa);
        if (resultado.equals("Ok")){
            return "Dados da pessoa atualizado com sucesso!";
        }
        else{
            return "Erro: " + resultado;
        }
    }
    // Excluir Pessoa
    public String excluiPessoa(int idpessoa){
        // Instancia um objeto do Modelo (Pessoa)
        Pessoa pessoa =  new Pessoa();
        // Define o idPessoa do objeto
        pessoa.setIdPessoa(idpessoa);
        // Instancia um objeto da camada DAO (PessoaDAO)
        PessoaDAO pessoaDAO = new PessoaDAO();
        // Exclui este Objeto (registro) no BD
        String resultado = pessoaDAO.delete(pessoa);
        if (resultado.equals("Ok")){
            return "Pessoa excluída com sucesso!";
        }
        else{
            return "Erro: " + resultado;
        }
    }
}
