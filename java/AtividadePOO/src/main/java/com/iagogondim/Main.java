package com.iagogondim;

import com.iagogondim.dao.ProdutoDAO;
import com.iagogondim.entities.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ProdutoDAO produtoDAO = new ProdutoDAO();

    produtoDAO.carregarDoArquivo("produtos.dat");
    int escolha;

    do {
      System.out.println("--------------------------");
      System.out.println("Escolha uma opção:");
      System.out.println("1. Inserir Produto");
      System.out.println("2. Alterar Produto");
      System.out.println("3. Excluir Produto");
      System.out.println("4. Visualizar Todos os Produtos");
      System.out.println("5. Visualizar Produto por ID");
      System.out.println("6. Salvar dados em arquivo");
      System.out.println("0. Sair");
      System.out.println("--------------------------");


      escolha = scanner.nextInt();
      scanner.nextLine();

      switch (escolha) {
        case 1:
          System.out.println("Digite o nome do produto:");
          String nomeInserir = scanner.nextLine();

          System.out.println("Digite descrição do produto:");
          String descricaoInserir = scanner.nextLine();

          System.out.println("Digite o preço do produto:");
          double precoInserir = scanner.nextDouble();

          System.out.println("Digite a quantidade do produto:");
          int estoqueInserir = scanner.nextInt();

          Produto produtoInserir = new Produto(0, nomeInserir, precoInserir, descricaoInserir, estoqueInserir);
          produtoDAO.inserirProduto(produtoInserir);
          break;
        case 2:
          System.out.println("Digite o ID do produto a ser alterado:");
          int idAlterar = scanner.nextInt();

          scanner.nextLine();

          System.out.println("Digite o novo nome do produto:");
          String nomeAlterar = scanner.nextLine();

          System.out.println("Digite descrição do produto:");
          String descricaoAlterar = scanner.nextLine();

          System.out.println("Digite o novo preço do produto:");
          double precoAlterar = scanner.nextDouble();

          System.out.println("Digite a quantidade do produto:");
          int estoqueAlterar = scanner.nextInt();

          Produto produtoAlterar = new Produto(idAlterar, nomeAlterar, precoAlterar, descricaoAlterar, estoqueAlterar);
          produtoDAO.alterarProduto(idAlterar, produtoAlterar);
          break;
        case 3:
          System.out.println("Digite o ID do produto a ser excluído:");
          int idExcluir = scanner.nextInt();
          produtoDAO.excluirProduto(idExcluir);
          break;
        case 4:
          List<Produto> todosProdutos = produtoDAO.selecionarTodos();
          System.out.println("Todos os produtos:");
          for (Produto produto : todosProdutos) {
            System.out.println("Codigo: " + produto.getId() + " - Nome: " + produto.getNome() + " - Descrição: " + produto.getDescricao() + " - Preço: R$" + produto.getPreco() + "Estoque: " + produto.getEstoque());

          }
          break;
        case 5:
          System.out.println("Digite o ID do produto a ser visualizado:");
          int idVisualizar = scanner.nextInt();
          Produto produtoVisualizar = produtoDAO.selecionarProduto(idVisualizar);
          if (produtoVisualizar != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Codigo: " + produtoVisualizar.getId() + " - Nome: " + produtoVisualizar.getNome() + " - Descrição: " + produtoVisualizar.getDescricao() + " - Preço: R$" + produtoVisualizar.getPreco() + "Estoque: " + produtoVisualizar.getEstoque());
          } else {
            System.out.println("Produto não encontrado.");
          }
          break;
        case 6:
          produtoDAO.salvarParaArquivo("produtos.dat");
          break;
        case 0:
          System.out.println("Saindo do programa. Até mais!");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    } while (escolha != 0);

    scanner.close();
  }
}