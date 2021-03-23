package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class LoginDao {
	
	private Connection connection;
	
	public LoginDao() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws Exception {
		String sql = "SELECT * FROM usuario WHERE login = ? and senha = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, senha);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) { 
			return true; /* Possui usuário */
		}
		
		/* Não possui usuário */
		return false;
	}
}
