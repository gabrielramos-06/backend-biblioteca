package br.edu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import br.edu.biblioteca.model.Emprestimo;
import br.edu.biblioteca.model.StatusEmprestimo;

public class EmprestimoRepository {
    private static final String ARQUIVO = "emprestimos.csv";

    public void salvarTodos(List<Emprestimo> emprestimos) {
        List<String> dadosCSV = new ArrayList<>();
        dadosCSV.add("ID_Emprestimo;ID_Usuario;ExemplarId;Data_Emprestimo;Data_Devolucao;Status");

        for (Emprestimo emprestimo : emprestimos) {
            dadosCSV.add(emprestimo.toString());
        }

        FileStorage.salvarDados(ARQUIVO, dadosCSV);
    }

    public List<Emprestimo> carregarTodos() {
        List<String> dadosCSV = FileStorage.carregarDados(ARQUIVO);
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (int i = 1; i < dadosCSV.size(); i++) {
            String[] colunas = dadosCSV.get(i).split(";");
            try {
                int id = colunas.length > 0 && !colunas[0].isEmpty() ? Integer.parseInt(colunas[0]) : 0;
                int usuarioId = colunas.length > 1 && !colunas[1].isEmpty() ? Integer.parseInt(colunas[1]) : 0;
                int exemplarId = colunas.length > 2 && !colunas[2].isEmpty() ? Integer.parseInt(colunas[2]) : 0;
                LocalDate dataEmp = colunas.length > 3 && !colunas[3].isEmpty() ? LocalDate.parse(colunas[3]) : null;
                LocalDate dataDev = colunas.length > 4 && !colunas[4].isEmpty() ? LocalDate.parse(colunas[4]) : null;
                StatusEmprestimo status = StatusEmprestimo.ATIVO;
                if (colunas.length > 5) {
                    try { status = StatusEmprestimo.valueOf(colunas[5].toUpperCase()); } catch (Exception e) { }
                }
                Emprestimo emp = new Emprestimo(id, usuarioId, exemplarId, dataEmp, null, status);
                emp.setDataDevolucao(dataDev);
                emprestimos.add(emp);
            } catch (Exception e) {
                
            }
        }

        return emprestimos;
    }
}