package servlet;

import java.io.IOException;

import beans.Produto;
import dao.ProdutoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.FormatarPreco;
import validation.ProdutoValidation;

@WebServlet("/salvarProduto")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProdutoDao produtoDao = new ProdutoDao();

    public ProdutoServlet() {
    }

    private void carregarListaProdutos(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher view = request.getRequestDispatcher("listaProdutos.jsp");
            request.setAttribute("produtos", produtoDao.listar());
            view.forward(request, response);
            return;

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
                return;
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
        produto.setQuantidade(!quantidade.isEmpty() ? Integer.parseInt(quantidade) : null);
        produto.setValor(!valor.isEmpty() ? new FormatarPreco().paraBigDec(valor) : null);
        /* StringBuilder que armazenará possíveis erros de validação */
        StringBuilder validacoesCampos = new ProdutoValidation().validarCampos(produto);

        if (validacoesCampos != null) {
            request.setAttribute("erroCampos", validacoesCampos);
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
            return;

        } else {
            
            if (id == null || id.isEmpty()) {
                if (produtoDao.isExisteProduto(nome)) {
                    request.setAttribute("msg", "Este produto já foi cadastrado");
                    /*
                     * Mantém os dados do usuários no formulário (recarrega) após algum erro de
                     * validação
                     */
                    request.setAttribute("produto", produto);
                    request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
                    return;
                } else {
                    produtoDao.salvar(produto);
                }
            }

            if (id != null && !id.isEmpty()) {
                if (produtoDao.isExisteProdutoOnUpdate(nome, Long.parseLong(id))) {
                    request.setAttribute("msg", "Já existe um produto com este nome");
                    request.setAttribute("produto", produto);
                    request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
                    return;
                } else {
                    produtoDao.atualizar(produto);
                }
            }
            
        }
        
        carregarListaProdutos(request, response);
    }

}
