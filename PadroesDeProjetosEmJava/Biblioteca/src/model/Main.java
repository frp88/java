package model;

import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        // Criar alguns objetos
        Professor prof1
                = new Professor("Fernando", 30, "Sistemas de Informação", 2000);
        Aluno aluno1 = new Aluno("Julia", 22, 1234,
                "Sistemas de Informação");
        Funcionario func1 = new Funcionario();
        // Define os valores para alguns atributos do func1
        func1.setNome("Lucimar");
        func1.setSalario(5000);

        // Insere um telefone para o aluno
        aluno1.addTelefone("9988-7766", "Celular");
        aluno1.addTelefone("3531-7070", "Fixo");
        aluno1.addTelefone("3531-8901", "Recado");
        System.out.println("Lista de telefones do(a) aluno(a): " +
                aluno1.getNome());
        // Percorre a lista de telefones do aluno
        for(Pessoa.Telefone tel : aluno1.getTelefones()){
            System.out.println("-- " + tel.getNumero() + 
                    " - " + tel.getTipo());
        }
        
        Editora editora1
                = new Editora("Libertas", 40, "123456");

        // Livros
        Livro livro1
                = new Livro("Engenharia de Software", 2015, 9, editora1);
        Livro livro2
                = new Livro("Banco de Dados", 2017, 5, editora1);
        Livro livro3
                = new Livro("Redes de Computadores", 2010, 3, editora1);
        
        // Exemplares
        Exemplar exemplar1 = new Exemplar(livro1, "01", true, false);
        Exemplar exemplar2 = new Exemplar(livro2, "02", true, false);
        Exemplar exemplar3 = new Exemplar(livro3, "03", true, false);
        Exemplar exemplar4 = new Exemplar(livro1, "01", true, true);
        
        // Emprestimo
        Emprestimo emp1 = new Emprestimo(func1, func1);
        // Inserir os livros ao empréstimo
        emp1.addExemplar(exemplar1);
        emp1.addExemplar(exemplar4);
        emp1.addExemplar(exemplar2);
        emp1.addExemplar(exemplar3);
        
        // Verifica quantos livros foram adicionados ao emprestimo
        System.out.println("Total de livros: " + 
                emp1.getExemplares().size());
        
        // Imprime informações do empréstimo
        System.out.println("--- Informações do Empréstimo ---");
        System.out.println("Nome: " + emp1.getPessoa().getNome());
        // Verifica se exite telefone cadastrado para a pessoa
        if (emp1.getPessoa().getTelefones().size() > 0){
            // Imprime o 1º telefone cadastrado
            System.out.println("Telefone: " + 
emp1.getPessoa().getTelefones().get(0).getNumero() + " - " + 
emp1.getPessoa().getTelefones().get(0).getTipo());
        }
        System.out.println("Livros emprestados: ");
        /// Imprime nome dos exemplares emprestados
        for (Exemplar exemplar : emp1.getExemplares()){
            System.out.println("-- " + exemplar.getLivro().getTitulo());
        }
        // Define o formato da data
        DateTimeFormatter formatoDaData =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Define a data formatada
        String dataFormatada =  
                emp1.getDataDevolucao().format(formatoDaData);
        System.out.println("Data de Devolução: " + 
               dataFormatada);
    }
}
