package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import beans.Produto;
import dao.ProdutoDao;
import jakarta.servlet.RequestDispatcher;
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

    private void carregarListaProdutos(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher view = request.getRequestDispatcher("listaProdutos.jsp");
            request.setAttribute("produtos", produtoDao.listar());
            view.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");
            String produto = request.getParameter("produto");

            if (acao.equalsIgnoreCase("listarProdutos")) {
                carregarListaProdutos(request, response);
            }

            if (acao.equalsIgnoreCase("delete")) {
                produtoDao.delete(Long.parseLong(produto));
                carregarListaProdutos(request, response);
            }

            if (acao.equalsIgnoreCase("editar")) {
                Produto produtoEditar = produtoDao.consultar(Long.parseLong(produto));
                RequestDispatcher view = request.getRequestDispatcher("cadastroProduto.jsp");
                request.setAttribute("produto", produtoEditar);
                view.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao != null && acao.equalsIgnoreCase("reset")) {
            carregarListaProdutos(request, response);
        }

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String valor = request.getParameter("valor");

        Produto produto = new Produto();
        produto.setId(!id.isEmpty() ? Long.parseLong(id) : null);
        produto.setNome(nome);
        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setValor(new BigDecimal(valor.replaceAll(",", ".")));
        
        if (id == null || id.isEmpty()) {
            produtoDao.salvar(produto);
        }
        
        if (id != null || !id.isEmpty()) {
            produtoDao.atualizar(produto);
        }
        
        carregarListaProdutos(request, response);
    }

}
