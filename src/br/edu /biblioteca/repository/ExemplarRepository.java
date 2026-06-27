package br.edu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.model.StatusExemplar;

public class ExemplarRepository {
    private static final String ARQUIVO = "exemplares.csv";

    public void salvarTodos(List<Exemplar> exemplares) {
        List<String> dadosCSV = new ArrayList<>();
        dadosCSV.add("ID_Exemplar;ISBN_Livro;Status");

        for (Exemplar exemplar : exemplares) {
            dadosCSV.add(exemplar.toString());
        }

        FileStorage.salvarDados(ARQUIVO, dadosCSV);
    }

    public List<Exemplar> carregarTodos() {
        List<String> dadosCSV = FileStorage.carregarDados(ARQUIVO);
        List<Exemplar> exemplares = new ArrayList<>();

        for (int i = 1; i < dadosCSV.size(); i++) {
            String[] colunas = dadosCSV.get(i).split(";");
            try {
                int id = colunas.length > 0 && !colunas[0].isEmpty() ? Integer.parseInt(colunas[0]) : 0;
                String isbn = colunas.length > 1 ? colunas[1] : "";
                StatusExemplar status = StatusExemplar.DISPONIVEL;
                if (colunas.length > 2) {
                    String s = colunas[2].toUpperCase();
                    try { status = StatusExemplar.valueOf(s); } catch (Exception e) { /* keep default */ }
                }
                Exemplar ex = new Exemplar(id, isbn, status);
                exemplares.add(ex);
            } catch (Exception e) {
                
            }
        }

        return exemplares;
    }
}