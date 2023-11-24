package com.iagogondim;

import com.iagogondim.dao.ProdutoDAO;
import com.iagogondim.entities.Produto;
import com.iagogondim.services.ProdutoServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();

    int escolha;
    do {
      System.out.println("--------------------------");
      System.out.println("Escolha uma opção:");
      System.out.println("1. Inserir Produto");
      System.out.println("2. Alterar Produto");
      System.out.println("3. Visualizar Todos os Produtos");
      System.out.println("4. Visualizar Produto por ID");
      System.out.println("5. Excluir Produto");
      System.out.println("6. Salvar dados em arquivo"); //falta implementar
      System.out.println("0. Sair");
      System.out.println("--------------------------");

      escolha = scanner.nextInt();
      scanner.nextLine();

      switch (escolha) {
        case 1:
          ProdutoServices.inserirProduto();
          break;
        case 2:
          ProdutoServices.alterarProduto();
          break;
        case 3:
          ProdutoServices.selecionarTodos();
          break;
        case 4:
          ProdutoServices.selecionarProduto();
          break;
        case 5:
          ProdutoServices.excluirProduto();
          break;
        case 6:
          break;
        case 0:
          System.out.println("Saindo da aplicação. Até mais!");
          produtoDAO.fecharConexao();
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    } while (escolha != 0);

    scanner.close();
  }
}