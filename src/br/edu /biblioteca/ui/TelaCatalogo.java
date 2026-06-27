package br.edu.biblioteca.ui;

import java.util.Scanner;
import br.edu.biblioteca.action.*;
import br.edu.biblioteca.model.Livro;

public class TelaCatalogo {
    public static java.util.List<Livro> acervo = new java.util.ArrayList<>(); 
    public static void exibir(Scanner scanner) {
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n--- TELA CATÁLOGO ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Buscar Livro (Listar Árvore/Busca Binária)");
            System.out.println("4. Ordenar Livros");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            
            switch (opcao) {
                case 1: { 
                    System.out.println("\n--- CADASTRAR NOVO LIVRO ---");
                    
                    System.out.print("Digite o ISBN: ");
                    String isbn = scanner.nextLine();
                    
                    System.out.print("Digite o Título: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Digite o Autor: ");
                    String autor = scanner.nextLine();
                    
                    System.out.print("Digite a Editora: ");
                    String editora = scanner.nextLine();
                    
                    System.out.print("Digite o Ano: ");
                    int ano = 0;
                    try {
                        ano = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido! O ano será salvo como 0.");
                    }
                    
                    System.out.print("Digite a Categoria: ");
                    String categoria = scanner.nextLine();

                    Livro novoLivro = new Livro(isbn, titulo, autor, editora, ano, categoria);
                    Acao cadastrar = new AcaoCadastrarLivro(novoLivro);
                    cadastrar.executar();
                    
                    System.out.println("Livro '" + titulo + "' cadastrado com sucesso!");
                    break;
                }
                case 2: { 
                    System.out.print("Informe o ISBN para remoção: ");
                    String isbn = scanner.nextLine();
                    Acao remover = new AcaoRemoverLivro(isbn);
                    remover.executar();
                    break;
                }
                case 3: {
                    System.out.println("\n--- BUSCAR LIVRO ---");
                    System.out.print("Digite o Título ou ISBN que deseja buscar: ");
                    String termo = scanner.nextLine().toLowerCase();
                    
                    boolean achou = false;
                    for (Livro l : acervo) {
                        
                        if (l.getIsbn().equalsIgnoreCase(termo) || l.getTitulo().toLowerCase().contains(termo)) {
                            System.out.println("\n✅ Encontrado: " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ")");
                            achou = true;
                        }
                    }
                    if (!achou) System.out.println("Este livro foi encontrado.");
                    break;
                }
                case 4: {
                    System.out.println("\n--- ORDENAR LIVROS ---");
                    System.out.println("1. Ordenar por Título");
                    System.out.println("2. Ordenar por Autor");
                    System.out.println("3. Ordenar por Ano");
                    System.out.print("Escolha o critério de ordenação: ");
                    
                    String criterio = scanner.nextLine();
                    
                    if (criterio.equals("1")) {
                        acervo.sort((l1, l2) -> l1.getTitulo().compareToIgnoreCase(l2.getTitulo()));
                        System.out.println("Livros ordenados por Título!");
                    } else if (criterio.equals("2")) {
                        acervo.sort((l1, l2) -> l1.toString().compareToIgnoreCase(l2.toString()));
                        System.out.println("Livros ordenados por Autor!");
                    } else {
                        System.out.println("Critério não implementado.");
                    }
                    
                    
                    for (Livro l : acervo) System.out.println(l.getTitulo());
                    break;
                }
                case 0: {
                    System.out.println("Voltando...");
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}