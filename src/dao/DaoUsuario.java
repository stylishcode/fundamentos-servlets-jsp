package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UsuarioBean;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UsuarioBean usuario) {
		try {
			String sql = "INSERT INTO usuario (nome,telefone,login,senha) VALUES (?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getTelefone());
			statement.setString(4, usuario.getSenha());
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

	public List<UsuarioBean> listar() throws Exception {
		List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();

		String sql = "SELECT * from usuario";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			UsuarioBean usuario = new UsuarioBean();
			
			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setTelefone(resultSet.getString("telefone"));
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
	
	public UsuarioBean consultar(Long id) throws SQLException {
		
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			UsuarioBean usuario = new UsuarioBean();
			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setTelefone(resultSet.getString("telefone"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			/*Retorna o usuário encontrado*/
			return usuario;
		}
		
		resultSet.close();
		/*Retorna null se o usuário não for encontrado*/
		return null;
	}
	
	public boolean isExisteLogin(String login) {
	    try {
	        String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login = ?";
	        
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, login);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	            return resultSet.getInt("qtd") > 0;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
        }
	    
	    return false; //Retorno padrão
	}
	
	public void atualizar(UsuarioBean usuario) {
		try {
			String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());
			statement.setLong(4, usuario.getId());
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
