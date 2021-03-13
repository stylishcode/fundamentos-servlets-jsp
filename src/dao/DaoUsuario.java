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
			
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));

			usuarios.add(usuario);
		}

		resultSet.close();

		return usuarios;
	}

	public void delete(Long id) {
		try {
			String sql = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
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
	
	public BeanLoginJsp consultar(Long id) throws SQLException {
		
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			BeanLoginJsp usuario = new BeanLoginJsp();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			/*Retorna o usuário encontrado*/
			return usuario;
		}
		
		resultSet.close();
		/*Retorna null se o usuário não for encontrado*/
		return null;
	}
	
	public void atualizar(BeanLoginJsp usuario) {
		try {
			String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setLong(3, usuario.getId());
			/* Se tudo estiver certo, executa a transação de atualizar no banco */
			statement.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		
	}

}
