package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnection;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/* Mapear filtro: Todas as urls (requisições e respostas) serão interceptadas por esse filtro*/
@WebFilter(urlPatterns = {"/*"})
public class Filter implements jakarta.servlet.Filter {

	/* Recebe a conexão vinda do init() */
	private static Connection connection;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*
		 * Este método sempre é chamado uma vez pelo contêiner da web para indicar a um
		 * filtro que ele está sendo colocado em serviço.
		 * 
		 * Nesse caso, o serviço será a instância de conexão com o banco de dados
		 */
		connection = SingleConnection.getConnection();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			/*
			 * O método doFilter () é invocado sempre que o usuário solicita qualquer
			 * recurso, para o qual o filtro está mapeado. É usado para realizar tarefas de
			 * filtragem. O container fornece referências de objeto de requisição e resposta
			 * para filtrar como argumento. FilterChain é usado para chamar o próximo filtro
			 * na cadeia tratar, de forma recursiva para reduzir o acoplamento. Este é um
			 * ótimo exemplo de Padrão de Cadeia de Responsabilidade.
			 */
			chain.doFilter(request, response);
			/* Caso ocorra tudo certo na filtragem, salva as alterações */
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		/*
		 * Quando o contêiner descarrega a instância do Filter, ele invoca o método
		 * destroy (). Este é o método onde podemos fechar quaisquer recursos abertos
		 * por filtro. Este método é chamado apenas uma vez durante a vida útil do
		 * filtro.
		 * 
		 * Como fechar a conexão com o banco por exemplo
		 */
	}
}
