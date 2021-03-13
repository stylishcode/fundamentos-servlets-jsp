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
			String user = request.getParameter("user"); /* id do usuário (user.id)*/

			if (acao.equals("delete")) {
				daoUsuario.delete(Long.parseLong(user)); /* converte o parâmetro String user.id para Long user.id */
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
			
			if (acao.equals("editar")) {
				BeanLoginJsp usuario = daoUsuario.consultar(Long.parseLong(user)); /* converte user.id para Long */
				/* Após editar, redireciona o usuário novamente para a página de cadastro */
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				/*
				 * Carrega o usuário que foi consultado e coloca dentro da variável(atributo) user
				 * para poder ser exibido em tela
				 */
				request.setAttribute("user", usuario);
				/* Redireciona o usuário para a página especificada */
				view.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		BeanLoginJsp usuario = new BeanLoginJsp();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if (id == null || id.isEmpty()) {			
			daoUsuario.salvar(usuario);
		} else {
			daoUsuario.atualizar(usuario);
		}


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
