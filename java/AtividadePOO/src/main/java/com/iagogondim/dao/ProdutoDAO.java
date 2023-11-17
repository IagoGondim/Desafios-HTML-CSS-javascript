package com.iagogondim.dao;

import com.iagogondim.entities.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
  private List<Produto> produtos;
  private int proximoId;

  public ProdutoDAO() {
    this.produtos = new ArrayList<>();
    this.proximoId = 1;
  }

  public void inserirProduto(Produto produto) {
    produto.setId(proximoId);
    produtos.add(produto);
    System.out.println("Produto inserido com sucesso!");
    proximoId++;
  }

  public void alterarProduto(int id, Produto novoProduto) {
    for (Produto produto : produtos) {
      if (produto.getId() == id) {
        produto.setNome(novoProduto.getNome());
        produto.setPreco(novoProduto.getPreco());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setEstoque(novoProduto.getEstoque());
        System.out.println("Produto alterado com sucesso!");
        return;
      }
    }
    System.out.println("Produto não encontrado para alteração.");
  }

  public void excluirProduto(int id) {
    produtos.removeIf(produto -> produto.getId() == id);
    System.out.println("Produto excluído com sucesso!");
  }

  public List<Produto> selecionarTodos() {
    return produtos;
  }

  public Produto selecionarProduto(int id) {
    for (Produto produto : produtos) {
      if (produto.getId() == id) {
        return produto;
      }
    }
    return null;
  }
  public void salvarParaArquivo(String nomeArquivo) {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
      outputStream.writeObject(produtos);
      System.out.println("Dados salvos para o arquivo com sucesso!");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Erro ao salvar os dados para o arquivo.");
    }
  }

  public void carregarDoArquivo(String nomeArquivo) {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
      List<Produto> produtosSalvos = (List<Produto>) inputStream.readObject();
      produtos.clear();
      produtos.addAll(produtosSalvos);
      proximoId = produtos.stream().mapToInt(Produto::getId).max().orElse(0) + 1;
      System.out.println("Dados carregados do arquivo com sucesso!");
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("Erro ao carregar os dados do arquivo.");
    }
  }

}
