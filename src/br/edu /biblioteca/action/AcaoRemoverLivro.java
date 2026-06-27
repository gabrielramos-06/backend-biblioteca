package br.edu.biblioteca.action;

public class AcaoRemoverLivro implements Acao {
    private String isbn;

    public AcaoRemoverLivro(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void executar() {
        System.out.println("Executando: Removendo o livro (ISBN: " + isbn + ") do acervo...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo: Restaurando o livro removido...");
    }

    @Override
    public String descricao() {
        return "Remoção de livro do acervo";
    }
}