package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo implements IEmprestimo {

    private List<Exemplar> exemplares;
    // pode ser um aluno, um professor ou um funcionário
    private Pessoa pessoa;
    private String situacao;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    // Funcionário que realizou o empréstimo
    private Funcionario funcionario;
    private Multa multa;

    public Emprestimo() {
        // Definir a lista de exemplares como vazia
        this.exemplares = new ArrayList<Exemplar>();
    }

    public Emprestimo(Pessoa pessoa, Funcionario funcionario) {
        this.pessoa = pessoa;
        this.funcionario = funcionario;
        this.situacao = "Ok";
        // Pega a data atual
        this.dataEmprestimo = LocalDate.now();
        // Chama a função que define a data de devolução
        this.definirDataDeDevolucao();
        // Inicia a lista de exemplares
        this.exemplares = new ArrayList<Exemplar>();
    }

    public Emprestimo(Pessoa pessoa, String situacao,
            LocalDate dataEmprestimo, LocalDate dataDevolucao,
            Funcionario funcionario) {
        this.pessoa = pessoa;
        this.situacao = situacao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.funcionario = funcionario;
        this.exemplares = new ArrayList<Exemplar>();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    // NÃO TEM O MÉTODO setExemplares()
    @Override
    public void addExemplar(Exemplar exemplar) {
        boolean podeEmprestar = true;
        // Veririca se pode emprestar mais livros  
        if (exemplares.size() >= IEmprestimo.qtdLivrosPorEmprestimo) {
            podeEmprestar = false;
            System.out.println("Quantidade de livros acima do permitido.");
        } else if (exemplar.isExclusivo()
                || !exemplar.isDisponivel()) {
            podeEmprestar = false;
            System.out.println("Livro exclusivo ou já emprestado.");
        }
        // Verifica se realmente pode emprestar o livro
        if (podeEmprestar == true) {
            // Adiciona um novo exemplar na lista
            this.exemplares.add(exemplar);
            System.out.println("Exemplar adicionado");
        }
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(float valor, boolean multaPaga) {
        // Cria uma multa para o próprio empréstimo
        Multa multa = new Multa(this, valor, multaPaga);
        this.multa = multa;
    }

    @Override
    public boolean devolverLivros() {
        // Altera a situação do emprestimo
        this.setSituacao("Devolvido");
        System.out.println("Livros devolvidos com sucesso!");
        return true;
    }

    @Override
    public void definirDataDeDevolucao() {
       // Declarar a quantidade de dias até devolver
        int qtdDias;
        // Verifica o tipo de pessoa que pegou os livros
        if (this.pessoa instanceof Funcionario) {
            qtdDias = 10;
        } else if (this.pessoa instanceof Professor) {
            qtdDias = 15;
        }
        else { // Se for aluno
            qtdDias = 7;
        }
         // Define a data de devolução
        LocalDate dtDevolucao = 
                LocalDate.now().plusDays(qtdDias);
            
        // Definir a data de devolução no atributo
        this.setDataDevolucao(dtDevolucao);
        // Definir a formatação da data
        DateTimeFormatter formatoDaData =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Define a data formatada
        String dataFormatada = dtDevolucao.format(formatoDaData);
        System.out.println("Você tem " + qtdDias 
                + " dias para devolver os livros.\n" + 
                "Data de devolução: " + dataFormatada);
    }

    // Classe Multa
    public class Multa {

        private Emprestimo emprestimo;
        private float valor;
        private boolean multaPaga;

        private Multa() {
        }

        private Multa(Emprestimo emprestimo,
                float valor, boolean multaPaga) {
            this.emprestimo = emprestimo;
            this.valor = valor;
            this.multaPaga = multaPaga;
        }

        public Emprestimo getEmprestimo() {
            return emprestimo;
        }

        // A CLASSE INTERNA NÃO POSSUI O MÉTODO QUE ALTERA 
        // O ATRIBUTO DA CLASSE EXTERNA, ou seja, 
        // não cria o método 'setEmprestimo()'
        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public boolean isMultaPaga() {
            return multaPaga;
        }

        public void setMultaPaga(boolean multaPaga) {
            this.multaPaga = multaPaga;
        }
    }
}
