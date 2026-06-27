package br.edu.biblioteca.ui;

import java.util.Scanner;

public class TelaRelatorios {
    
    public static void exibir(Scanner scanner) {
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n--- TELA DE RELATÓRIOS ---");
            System.out.println("1. Livros mais emprestados");
            System.out.println("2. Usuários inadimplentes (com multa)");
            System.out.println("3. Histórico de operações (Pilha)");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            
            switch (opcao) {
                case 1:
                    System.out.println("Gerando relatório de livros mais emprestados...");
                    break;
                case 2:
                    System.out.println("Gerando relatório de usuários inadimplentes...");
                    break;
                case 3:
                    System.out.println("Exibindo histórico da Pilha de Ações...");
                    
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}