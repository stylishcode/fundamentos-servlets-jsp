package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer a conexão com o banco de dados
 * @author matheus
 * */
public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "matheus";
	private static String password = "fallen";
	private static Connection connection = null;
	/* Executa uma única vez após o ClassLoader carregar a classe na memória */
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				/* Carrega a classe e registra no DriverManager */
				Class.forName("org.postgresql.driver");
				connection = DriverManager.getConnection(url, user, password);
				/*
				 * Se uma conexão estiver no modo de confirmação automática, todas as instruções
				 * SQL serão executadas e confirmadas como transações individuais. Caso
				 * contrário, suas instruções SQL serão agrupadas em transações que são
				 * terminadas por uma chamada aos métodos commit ou rollback. Por padrão, as
				 * novas conexões ficam no modo de confirmação automática.
				 */
				connection.setAutoCommit(false);
				System.out.println("Conectado com sucesso.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados.");
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
