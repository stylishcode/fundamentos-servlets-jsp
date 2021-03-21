package servlet;

import java.io.IOException;

import beans.UsuarioBean;
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
    
    private void carregarListaUsuarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            /* Define um redirecionamento de pagina */
            RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
            /*Define um atributo usuarios que contem a lista de usuários carregada*/
            request.setAttribute("usuarios", daoUsuario.listar());
            /*Redireciona para a página definida*/
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String acao = request.getParameter("acao");
            String user = request.getParameter("user"); /* id do usuário (user.id) */

            if (acao.equalsIgnoreCase("listartodos")) {
                carregarListaUsuarios(request, response);
            }

            if (acao.equalsIgnoreCase("delete")) {
                daoUsuario.delete(Long.parseLong(user)); /* converte o parâmetro String user.id para Long user.id */
                carregarListaUsuarios(request, response);
            }

            if (acao.equalsIgnoreCase("editar")) {
                UsuarioBean usuario = daoUsuario.consultar(Long.parseLong(user)); /* converte user.id para Long */
                /* Após editar, redireciona o usuário novamente para a página de cadastro */
                RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
                /*
                 * Carrega o usuário que foi consultado e coloca dentro da variável(atributo)
                 * user para poder ser exibido em tela
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

        String acao = request.getParameter("acao");

        /*
         * Caso o usuário cancele edição ou cadastro, ele é redirecionado para a pagina
         * de cadastro novamente e a lista de usuários é carregada
         */
        if (acao != null && acao.equalsIgnoreCase("reset")) {
            carregarListaUsuarios(request, response);
        }

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioBean usuario = new UsuarioBean();
        usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        
        if (id == null || id.isEmpty() && daoUsuario.isExisteLogin(login)) {
            request.setAttribute("msg", "Usuário já existe com o mesmo login");
        }

        if (id == null || id.isEmpty() && !daoUsuario.isExisteLogin(login)) {
            daoUsuario.salvar(usuario);
            
        } 
        
        if (id != null && !id.isEmpty()) {
            daoUsuario.atualizar(usuario);
        }
        
       carregarListaUsuarios(request, response);
    }

}
