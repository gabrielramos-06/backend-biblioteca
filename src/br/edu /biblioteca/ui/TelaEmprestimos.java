package br.edu.biblioteca.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.biblioteca.action.*;
import br.edu.biblioteca.model.Emprestimo;

public class TelaEmprestimos {
    
   
public static List<Emprestimo> listaEmprestimos = new ArrayList<>();

    public static void exibir(Scanner scanner) {
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n--- TELA DE EMPRÉSTIMOS ---");
            System.out.println("1. Realizar Empréstimo");
            System.out.println("2. Registrar Devolução");
            System.out.println("3. Consultar Multas");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("ID do Usuário: ");
                    String idUsuarioEmp = scanner.nextLine();
                    System.out.print("ISBN do Livro: ");
                    String isbnEmp = scanner.nextLine();
                    
                    Acao emprestar = new AcaoEmpresta(idUsuarioEmp, isbnEmp);
                    emprestar.executar();
                    break;
                case 2:
                    System.out.print("ID do Usuário: ");
                    String idUsuarioDev = scanner.nextLine();
                    System.out.print("ISBN do Livro: ");
                    String isbnDev = scanner.nextLine();
                    
                    Acao devolver = new AcaoDevolver(idUsuarioDev, isbnDev);
                    devolver.executar();
                    break;
                 case 3:
                    System.out.println("Função de consultar multas em manutencao...");
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
