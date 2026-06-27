package br.edu.biblioteca.ui;
import java.util.Scanner;



public class MenuPrincipal {
    public static Object historicoAcoes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Catálogo de Livros");
            System.out.println("2. Gestão de Usuários");
            System.out.println("3. Controle de Empréstimos");
            System.out.println("4. Controle de Reservas");
            System.out.println("5. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1: TelaCatalogo.exibir(scanner); break;
                case 2:
    TelaUsuarios.exibir(scanner);
    break;

case 3:
    TelaEmprestimos.exibir(scanner);
    break;

case 4:
    TelaReservas.exibir(scanner);
    break;

case 5:
    TelaRelatorios.exibir(scanner);
    break;
                case 0: System.out.println("Encerrando o sistema..."); break;
                default: System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}