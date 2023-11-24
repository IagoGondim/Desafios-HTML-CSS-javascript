package com.iagogondim.services;

import com.iagogondim.dao.ProdutoDAO;
import com.iagogondim.entities.Produto;

import java.util.List;
import java.util.Scanner;


public class ProdutoServices {

  public static void inserirProduto() {
    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();

    System.out.print("Digite o nome do produto: ");
    String nome = scanner.nextLine();

    System.out.print("Digite a descrição do produto: ");
    String descricao = scanner.nextLine();

    System.out.print("Digite o preço do produto: ");
    double preco = scanner.nextDouble();

    System.out.println("Digite a quantidade do produto:");
    int estoque = scanner.nextInt();

    Produto novoProduto = new Produto();
    novoProduto.setNome(nome);
    novoProduto.setDescricao(descricao);
    novoProduto.setPreco(preco);
    novoProduto.setEstoque(estoque);

    produtoDAO.inserirProduto(novoProduto);

    System.out.println("Produto inserido com sucesso!");
  }

  public static void alterarProduto() {
    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();
    System.out.print("Digite o ID do produto que deseja atualizar: ");
    int id = scanner.nextInt();

    Produto produtoExistente = produtoDAO.consultarPorId(id);

    if (produtoExistente != null) {
      scanner.nextLine();
      System.out.print("Digite o novo nome do produto: ");
      String novoNome = scanner.nextLine();

      System.out.print("Digite a nova descrição do produto: ");
      String novaDescricao = scanner.nextLine();

      System.out.print("Digite o novo preço do produto: ");
      double novoPreco = scanner.nextDouble();

      System.out.print("Digite o novo estoque do produto: ");
      int novoEstoque = scanner.nextInt();


      produtoExistente.setNome(novoNome);
      produtoExistente.setDescricao(novaDescricao);
      produtoExistente.setPreco(novoPreco);
      produtoExistente.setEstoque(novoEstoque);

      produtoDAO.alterarProduto(produtoExistente);

      System.out.println("Produto alterado com sucesso!");
    } else {
      System.out.println("Produto não encontrado para alteração.");
    }
  }

  public static void excluirProduto() {
    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();

    System.out.print("Digite o ID do produto que deseja excluir: ");
    int id = scanner.nextInt();

    Produto produtoExistente = produtoDAO.consultarPorId(id);

    if (produtoExistente != null) {
      produtoDAO.excluirProduto(id);
      System.out.println("Produto excluído com sucesso!");
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

  public static void selecionarProduto() {
    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();

    System.out.print("Digite o ID do produto a ser visualizado:");
    int id = scanner.nextInt();

    Produto produto = produtoDAO.consultarPorId(id);

    if (produto != null) {
      System.out.println("Produto encontrado:");
      System.out.println(produto);
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

  public static void selecionarTodos() {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    List<Produto> produtos = produtoDAO.selecionarTodos();
    if (produtos.isEmpty()) {
      System.out.println("Nenhum produto encontrado.");
    } else {
      System.out.println("Lista de Produtos:");
      for (Produto produto : produtos) {
        System.out.println(produto);
      }
    }

  }

}
