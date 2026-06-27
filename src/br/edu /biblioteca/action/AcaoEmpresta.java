package br.edu.biblioteca.action;

public class AcaoEmpresta implements Acao {
    private String idUsuario;
    private String isbn;

    public AcaoEmpresta(String idUsuario, String isbn) {
        this.idUsuario = idUsuario;
        this.isbn = isbn;
    }

    @Override
    public void executar() {
        System.out.println("Executando: Registrando empréstimo do livro '" + isbn + "' para usuário '" + idUsuario + "'...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo: Cancelando registro de empréstimo do livro '" + isbn + "' para usuário '" + idUsuario + "'...");
    }

    @Override
    public String descricao() {
        return "Empréstimo de livro";
    }
}