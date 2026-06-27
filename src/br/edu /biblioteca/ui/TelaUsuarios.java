package br.edu.biblioteca.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.biblioteca.model.Usuario;

public class TelaUsuarios {

    
    public static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- TELA DE USUÁRIOS ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Atualizar Usuário");
            System.out.println("3. Listar Usuários");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1: 
                    System.out.print("Digite o ID: ");
                    String idStr = scanner.nextLine();
                    int idInt = 0;
                    try {
                        idInt = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido! Usando 0 como ID.");
                    }
                    System.out.print("Digite o Nome: ");
                    String nome = scanner.nextLine();
                    listaUsuarios.add(new Usuario(idInt, nome, null, ""));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2: 
                    System.out.print("Digite o ID do usuário que deseja atualizar: ");
                    String idBusca = scanner.nextLine();
                    int idBuscaInt;
                    try {
                        idBuscaInt = Integer.parseInt(idBusca);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }
                    boolean achou = false;
                    for (Usuario u : listaUsuarios) {
                        if (u.getId() == idBuscaInt) {
                            System.out.print("Digite o novo nome para " + u.getNome() + ": ");
                            String novoNome = scanner.nextLine();
                            u.setNome(novoNome);
                            System.out.println("Usuário atualizado!");
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) System.out.println("Usuário não encontrado.");
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE USUÁRIOS ---");
                    if (listaUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (Usuario u : listaUsuarios) {
                            System.out.println(u.toString());
                        }
                    }
                    break;

                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}