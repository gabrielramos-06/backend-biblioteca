package br.edu.biblioteca.ui;
import java.util.Scanner;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Queue;    
import java.util.*;
import br.edu.biblioteca.action.*;


public class TelaReservas {
    public static Map<String, Queue<String>> filasDeReserva = new HashMap<>(); 
    public static void exibir(Scanner scanner) {
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n--- TELA DE RESERVAS ---");
            System.out.println("1. Reservar Livro (Entrar na Fila)");
            System.out.println("2. Cancelar Reserva (Sair da Fila)");
            System.out.println("3. Ver Fila de um Livro");
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
                    String idUsuarioRes = scanner.nextLine();
                    System.out.print("ISBN do Livro: ");
                    String isbnRes = scanner.nextLine();

                    filasDeReserva.computeIfAbsent(isbnRes, k -> new LinkedList<>()).add(idUsuarioRes); 
                    System.out.println("Usuário " + idUsuarioRes + " entrou na fila do livro " + isbnRes); 
                    
                    Acao reservar = new AcaoReservar(idUsuarioRes, isbnRes);
                    reservar.executar();
                    break;
                case 2:
                    System.out.print("ID do Usuário: ");
                    String idUsuarioCanc = scanner.nextLine();
                    System.out.print("ISBN do Livro: ");
                    String isbnCanc = scanner.nextLine();

                    if (filasDeReserva.containsKey(isbnCanc)) {
                        filasDeReserva.get(isbnCanc).remove(idUsuarioCanc);
                        System.out.println("Reserva de " + idUsuarioCanc + " cancelada.");
                    }
                        
                    
                    Acao cancelar = new AcaoCancelarReserva(idUsuarioCanc, isbnCanc);
                    cancelar.executar();
                    break;
                case 3:
                    System.out.print("Digite o ISBN do livro para ver a fila: ");
                    String isbnConsulta = scanner.nextLine();
                    
                    if (filasDeReserva.containsKey(isbnConsulta) && !filasDeReserva.get(isbnConsulta).isEmpty()) {
                        System.out.println("\n--- FILA DO LIVRO " + isbnConsulta + " ---");
                        int posicao = 1;
                        for (String idUsuario : filasDeReserva.get(isbnConsulta)) {
                            System.out.println(posicao + "º lugar: Usuário " + idUsuario);
                            posicao++;
                        }
                    } else {
                        System.out.println("Não há reservas para este livro.");
                    }
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