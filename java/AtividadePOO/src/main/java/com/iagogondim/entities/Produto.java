package com.iagogondim.entities;

import java.io.Serializable;

public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String nome;
  private String descricao;
  private double preco;
  private int estoque;

  public Produto(int id, String nome, double preco, String descricao, int estoque) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.descricao = descricao;
    this.estoque = estoque;
  }
  public Produto() {

  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  @Override
  public String toString() {
    return "Produto{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", preco=" + preco +
            ", descricao='" + descricao + '\'' +
            ", estoque=" + estoque +
            '}';
  }


}
