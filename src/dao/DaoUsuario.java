package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanLoginJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanLoginJsp usuario) {
		try {
			String sql = "INSERT INTO usuario (login,senha) VALUES (?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.execute();
			/* Se tudo estiver certo, ele executa a transação de salvar no banco */
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

	public List<BeanLoginJsp> listar() throws Exception {
		List<BeanLoginJsp> usuarios = new ArrayList<BeanLoginJsp>();

		String sql = "SELECT * from usuario";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			BeanLoginJsp usuario = new BeanLoginJsp();

			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));

			usuarios.add(usuario);
		}

		resultSet.close();

		return usuarios;
	}

	public void delete(String login) {
		try {
			String sql = "DELETE FROM usuario WHERE login = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.execute();
			/* Se tudo estiver certo, ele executa a transação de deletar no banco */
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

}
