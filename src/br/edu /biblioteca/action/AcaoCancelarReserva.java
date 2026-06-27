package br.edu.biblioteca.action;

public class AcaoCancelarReserva implements Acao {
    private String idUsuario;
    private String isbn;

    public AcaoCancelarReserva(String idUsuario, String isbn) {
        this.idUsuario = idUsuario;
        this.isbn = isbn;
    }

    @Override
    public void executar() {
        System.out.println("Executando: Removendo usuário '" + idUsuario + "' da fila de reserva do livro '" + isbn + "'...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo: Recolocando usuário '" + idUsuario + "' na fila de reserva do livro '" + isbn + "'...");
    }

    @Override
    public String descricao() {
        return "Cancelamento de reserva";
    }
}