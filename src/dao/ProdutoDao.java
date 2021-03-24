package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import connection.SingleConnection;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Produto produto) {
        try {
            String sql = "INSERT INTO produto (nome,quantidade,valor) VALUES (?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getQuantidade());
            pst.setBigDecimal(3, produto.getValor());
            pst.execute();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();

        String sql = "SELECT * FROM produto";

        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getLong(("id")));
            produto.setNome(resultSet.getString(("nome")));
            produto.setQuantidade(resultSet.getInt(("quantidade")));
            produto.setValor(resultSet.getBigDecimal(("valor")));

            produtos.add(produto);
        }

        resultSet.close();

        return produtos;
    }

    public void atualizar(Produto produto) {
        try {
            String sql = "UPDATE produto SET nome = ?, quantidade = ?, valor = ? WHERE id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getQuantidade());
            pst.setBigDecimal(3, produto.getValor());
            pst.setLong(4, produto.getId());
            pst.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        try {
            String sql = "DELETE FROM produto WHERE id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            pst.execute();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Produto consultar(Long id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, id);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getLong("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
            produto.setValor(resultSet.getBigDecimal("valor"));

            return produto;
        }

        resultSet.close();
        return null;
    }

    public boolean isExisteProduto(String nome) {
        try {
            String sql = "SELECT COUNT(1) AS qtde FROM produto WHERE nome = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("qtde") > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isExisteProdutoOnUpdate(String nome, Long id) {
        try {
            String sql = "SELECT COUNT(1) AS qtde FROM produto WHERE nome = ? and id <> ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setLong(2, id);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("qtde") > 0;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
