package br.edu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.biblioteca.model.Usuario;
import br.edu.biblioteca.model.TipoUsuario;

public class UsuarioRepository {
    private static final String ARQUIVO = "usuarios.csv";

    public void salvarTodos(List<Usuario> usuarios) {
        List<String> dadosCSV = new ArrayList<>();
        dadosCSV.add("ID;Nome;TipoUsuario;Email;Bloqueado");

        for (Usuario usuario : usuarios) {
            dadosCSV.add(usuario.toString());
        }

        FileStorage.salvarDados(ARQUIVO, dadosCSV);
    }

    public List<Usuario> carregarTodos() {
        List<String> dadosCSV = FileStorage.carregarDados(ARQUIVO);
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 1; i < dadosCSV.size(); i++) {
            String[] colunas = dadosCSV.get(i).split(";");
            try {
                int id = colunas.length > 0 && !colunas[0].isEmpty() ? Integer.parseInt(colunas[0]) : 0;
                String nome = colunas.length > 1 ? colunas[1] : "";
                TipoUsuario tipo = null;
                if (colunas.length > 2 && !colunas[2].isEmpty()) {
                    try { tipo = TipoUsuario.valueOf(colunas[2].toUpperCase()); } catch (Exception e) { }
                }
                String email = colunas.length > 3 ? colunas[3] : "";
                boolean bloqueado = false;
                if (colunas.length > 4 && !colunas[4].isEmpty()) {
                    bloqueado = Boolean.parseBoolean(colunas[4]);
                }
                Usuario u = new Usuario(id, nome, tipo, email);
                u.setBloqueado(bloqueado);
                usuarios.add(u);
            } catch (Exception e) {
                System.err.println("Erro ao processar linha: " + dadosCSV.get(i));
            }
        }

        return usuarios;
    }
}