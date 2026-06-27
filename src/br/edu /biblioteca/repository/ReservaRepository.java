package br.edu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.model.StatusReserva;

public class ReservaRepository {
    private static final String ARQUIVO = "reservas.csv";

    public void salvarTodos(List<Reserva> reservas) {
        List<String> dadosCSV = new ArrayList<>();
        dadosCSV.add("ID_Reserva;ID_Usuario;ISBN_Livro;Data_Reserva;Status");

        for (Reserva reserva : reservas) {
            dadosCSV.add(reserva.toString());
        }

        FileStorage.salvarDados(ARQUIVO, dadosCSV);
    }

    public List<Reserva> carregarTodos() {
        List<String> dadosCSV = FileStorage.carregarDados(ARQUIVO);
        List<Reserva> reservas = new ArrayList<>();

        for (int i = 1; i < dadosCSV.size(); i++) {
            String[] colunas = dadosCSV.get(i).split(";");
            try {
                int id = colunas.length > 0 && !colunas[0].isEmpty() ? Integer.parseInt(colunas[0]) : 0;
                int usuarioId = colunas.length > 1 && !colunas[1].isEmpty() ? Integer.parseInt(colunas[1]) : 0;
                String isbn = colunas.length > 2 ? colunas[2] : "";
                LocalDate data = null;
                if (colunas.length > 3 && !colunas[3].isEmpty()) {
                    try { data = LocalDate.parse(colunas[3]); } catch (Exception e) { }
                }
                StatusReserva status = StatusReserva.RESERVADO;
                if (colunas.length > 4 && !colunas[4].isEmpty()) {
                    try { status = StatusReserva.valueOf(colunas[4].toUpperCase()); } catch (Exception e) { }
                }
                Reserva r = new Reserva(id, usuarioId, isbn, data, status);
                reservas.add(r);
            } catch (Exception e) {
                
            }
        }

        return reservas;
    }
}