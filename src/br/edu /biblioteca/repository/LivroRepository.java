package br.edu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.biblioteca.model.Livro;

public class LivroRepository {
    private static final String ARQUIVO = "livros.csv";

    public void salvarTodos(List<Livro> livros) {
        List<String> dadosCSV = new ArrayList<>();
        
        dadosCSV.add("ISBN;Titulo;Ano");

        for (Livro livro : livros) {
            
            dadosCSV.add(String.format("%s;%s;%d", livro.getIsbn(), livro.getTitulo(), livro.getAno()));
        }

        FileStorage.salvarDados(ARQUIVO, dadosCSV);
    }

    public List<Livro> carregarTodos() {
        List<String> dadosCSV = FileStorage.carregarDados(ARQUIVO);
        List<Livro> livros = new ArrayList<>();

        
        for (int i = 1; i < dadosCSV.size(); i++) {
            String[] colunas = dadosCSV.get(i).split(";");
            try {
                String isbn = colunas.length > 0 ? colunas[0] : "";
                String titulo = colunas.length > 1 ? colunas[1] : "";
                int ano = 0;
                if (colunas.length > 2 && !colunas[2].isEmpty()) {
                    try { ano = Integer.parseInt(colunas[2]); } catch (NumberFormatException e) { }
                }
                Livro l = new Livro(isbn, titulo, ano);
                livros.add(l);
            } catch (Exception e) {
                System.err.println("Erro ao processar linha: " + dadosCSV.get(i));
            }
        }

        return livros;
    }
}
