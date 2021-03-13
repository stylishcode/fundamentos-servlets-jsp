package servlet;

import java.io.IOException;

import beans.BeanLoginJsp;
import dao.DaoUsuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salvarUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public UsuarioServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao.equals("delete")) {
				daoUsuario.delete(user);
				/* Após deletar, redireciona o usuário novamente para a página de cadastro */
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				/*
				 * Carrega a lista de usuários e colocar dentro da variável(atributo) usuarios
				 * para poder ser exibido em tela
				 */
				request.setAttribute("usuarios", daoUsuario.listar());
				/* Redireciona o usuário para a página especificada */
				view.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		BeanLoginJsp usuario = new BeanLoginJsp();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		daoUsuario.salvar(usuario);

		/* Após salvar, redireciona o usuário novamente para a página de cadastro */
		try {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			/*
			 * Carrega a lista de usuários e colocar dentro da variável(atributo) usuarios
			 * para poder ser exibido em tela
			 */
			request.setAttribute("usuarios", daoUsuario.listar());
			/* Redireciona o usuário para a página especificada */
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
