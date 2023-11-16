package com.iagogondim.dao;

import com.iagogondim.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
  private List<Produto> produtos;
  private int proximoId;

  public ProdutoDAO() {
    this.produtos = new ArrayList<>();
    this.proximoId = 0;
  }

  public void inserirProduto(Produto produto) {
    produtos.add(produto);
    System.out.println("Produto inserido com sucesso!");
  }

  public void alterarProduto(int id, Produto novoProduto) {
    for (Produto produto : produtos) {
      if (produto.getId() == id) {
        produto.setNome(novoProduto.getNome());
        produto.setPreco(novoProduto.getPreco());
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

  public int getNextId() {
    proximoId++;
    return proximoId;
  }
}
