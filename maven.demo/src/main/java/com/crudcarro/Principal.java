package com.crudcarro;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CarroDAO dao = new CarroDAO();
            int opc;

            do {
                System.out.println("\n=== CRUD CARRO ===");
                System.out.println("1 - Listar");
                System.out.println("2 - Inserir");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Excluir");
                System.out.println("5 - Sair");
                System.out.print("Escolha: ");
                opc = sc.nextInt();
                sc.nextLine(); // consumir quebra de linha

                switch(opc) {
                    case 1: // Listar
                        List<Carro> lista = dao.listar();
                        lista.forEach(System.out::println);
                        break;
                    case 2: // Inserir
                        System.out.print("Modelo: "); String modelo = sc.nextLine();
                        System.out.print("Marca: "); String marca = sc.nextLine();
                        System.out.print("Ano: "); int ano = sc.nextInt(); sc.nextLine();
                        System.out.print("Cor: "); String cor = sc.nextLine();
                        System.out.print("Preco: "); double preco = sc.nextDouble(); sc.nextLine();
                        dao.inserir(new Carro(modelo, marca, ano, cor, preco));
                        System.out.println("Carro inserido!");
                        break;
                    case 3: // Atualizar
                        System.out.print("ID do carro: "); int idAt = sc.nextInt(); sc.nextLine();
                        System.out.print("Modelo: "); String modeloAt = sc.nextLine();
                        System.out.print("Marca: "); String marcaAt = sc.nextLine();
                        System.out.print("Ano: "); int anoAt = sc.nextInt(); sc.nextLine();
                        System.out.print("Cor: "); String corAt = sc.nextLine();
                        System.out.print("Preco: "); double precoAt = sc.nextDouble(); sc.nextLine();
                        dao.atualizar(new Carro(idAt, modeloAt, marcaAt, anoAt, corAt, precoAt));
                        System.out.println("Carro atualizado!");
                        break;
                    case 4: // Excluir
                        System.out.print("ID do carro: "); int idEx = sc.nextInt(); sc.nextLine();
                        dao.excluir(idEx);
                        System.out.println("Carro excluído!");
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while(opc != 5);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}