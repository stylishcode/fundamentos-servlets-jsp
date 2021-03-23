package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import beans.Produto;
import dao.ProdutoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/salvarProduto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProdutoDao produtoDao = new ProdutoDao();
    
    public ProdutoServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        
	        String id = request.getParameter("id");
	        String nome = request.getParameter("nome");
	        String quantidade = request.getParameter("quantidade");
	        String valor = request.getParameter("valor");
	        
	        Produto produto = new Produto();
	        produto.setId(!id.isEmpty() ? Long.parseLong(id) : null);
	        produto.setNome(nome);
	        produto.setQuantidade(Integer.parseInt(quantidade));
	        produto.setValor(BigDecimal.valueOf(Double.parseDouble(valor)));
	       
	        produtoDao.salvar(produto);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
