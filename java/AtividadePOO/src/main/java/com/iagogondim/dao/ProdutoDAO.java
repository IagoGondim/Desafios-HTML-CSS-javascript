package com.iagogondim.dao;

import com.iagogondim.entities.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {
  private static Scanner scanner = new Scanner(System.in);
  private static ProdutoDAO produtoDAO = new ProdutoDAO();
  private Connection connection;

  public ProdutoDAO() {
    String jdbcUrl = "jdbc:mysql://localhost:3306/atividadejava";
    String user = "root";
    String password = "root";

    try {
      this.connection = DriverManager.getConnection(jdbcUrl, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao conectar ao banco de dados.");
    }
  }

  public void inserirProduto(Produto produto) {
    try {
      String query = "INSERT INTO produtos (nome, descricao, preco, estoque) VALUES (?, ?, ?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setString(2, produto.getDescricao());
        preparedStatement.setDouble(3, produto.getPreco());
        preparedStatement.setInt(4, produto.getEstoque());

        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao criar produto.");
    }
  }

  public void alterarProduto(Produto produto) {
    try {
      String query = "UPDATE produtos SET nome=?, descricao=?, preco=?, estoque=? WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setString(2, produto.getDescricao());
        preparedStatement.setDouble(3, produto.getPreco());
        preparedStatement.setInt(4, produto.getEstoque());
        preparedStatement.setInt(5, produto.getId());

        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao atualizar produto.");
    }
  }

  public void excluirProduto(int id) {
    try {
      String query = "DELETE FROM produtos WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao excluir produto.");
    }
  }

  public Produto consultarPorId(int id) {
    try {
      String query = "SELECT * FROM produtos WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setEstoque(resultSet.getInt("estoque"));

            return produto;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao consultar produto por ID.");
    }
    return null;
  }

  public List<Produto> selecionarTodos() {
    List<Produto> produtos = new ArrayList<>();
    try {
      String query = "SELECT * FROM produtos";
      try (Statement statement = connection.createStatement()) {
        try (ResultSet resultSet = statement.executeQuery(query)) {
          while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setEstoque(resultSet.getInt("estoque"));

            produtos.add(produto);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao consultar produtos.");
    }
    return produtos;
  }

  public void fecharConexao() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
