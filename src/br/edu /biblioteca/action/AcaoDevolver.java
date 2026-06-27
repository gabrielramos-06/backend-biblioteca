package br.edu.biblioteca.action;

public class AcaoDevolver implements Acao {
    private String idUsuario;
    private String isbn;

    public AcaoDevolver(String idUsuario, String isbn) {
        this.idUsuario = idUsuario;
        this.isbn = isbn;
    }

    @Override
    public void executar() {
        System.out.println("Executando: Registrando devolução do livro '" + isbn + "' pelo usuário '" + idUsuario + "' e verificando multas...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo: Revertendo devolução do livro '" + isbn + "' para status de emprestado do usuário '" + idUsuario + "'...");
    }

    @Override
    public String descricao() {
        return "Devolução de livro";
    }
}