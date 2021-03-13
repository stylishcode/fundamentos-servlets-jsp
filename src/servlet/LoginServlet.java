package servlet;

import java.io.IOException;

import beans.BeanLoginJsp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BeanLoginJsp beanLoginJsp = new BeanLoginJsp();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (beanLoginJsp.isLoginValido(login, senha)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
