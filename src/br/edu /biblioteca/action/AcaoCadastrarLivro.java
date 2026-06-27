package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Livro;

public class AcaoCadastrarLivro implements Acao {
    private Livro livro; 
    
    public AcaoCadastrarLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public void executar() {
        String titulo = (livro != null && livro.getTitulo() != null) ? livro.getTitulo() : "(sem título)";
        System.out.println("Executando: Cadastrando o livro '" + titulo + "' no acervo...");
        
    }

    @Override
    public void desfazer() {
        String titulo = (livro != null && livro.getTitulo() != null) ? livro.getTitulo() : "(sem título)";
        System.out.println("Desfazendo: Removendo o livro '" + titulo + "' recém-cadastrado...");
       
    }

    @Override
    public String descricao() {
        return "Cadastro de um novo livro";
    }
}