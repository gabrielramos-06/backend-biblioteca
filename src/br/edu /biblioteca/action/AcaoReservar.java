package br.edu.biblioteca.action;

public class AcaoReservar implements Acao {
    private String idUsuario;
    private String isbn;

    public AcaoReservar(String idUsuario, String isbn) {
        this.idUsuario = idUsuario;
        this.isbn = isbn;
    }

    @Override
    public void executar() {
        System.out.println("Executando: Adicionando usuário " + idUsuario + " à fila de reserva do livro " + isbn + "...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo: Removendo usuário da fila de reserva...");
    }

    @Override
    public String descricao() {
        return "Reserva de livro";
    }
}