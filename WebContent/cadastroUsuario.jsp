<%@page
  import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de usuário</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
    <link rel="stylesheet" type="text/css" href="resources/css/tabela.css"
</head>

<body>
    <form action="salvarUsuario" method="post">
        <fieldset>
            <legend>Cadastro de usuários</legend>
            
            <h3 style="margin-bottom: 0.35rem; color: orange">${msg}</h3>
            
            <input type="text" name="id" id="id" readonly="readonly" placeholder="Gerado automaticamente" 
                   value="${user.id}" class="hidden-input-id"> 
                   
            <label>Nome <span>*</span></label>
            <input type="text" name="nome" id="nome" placeholder="Nome" 
                   value="${user.nome}" required>
                   
            <label>Telefone <span>*</span></label>
            <input type="tel" name="telefone" id="telefone" placeholder="Telefone" 
                   value="${user.telefone}" pattern="(\(?\d{2}\)?\s)?(\d{4,5}\-\d{4})" required>
        
            <label>Login <span>*</span></label>
            <input type="text" name="login" id="login" placeholder="Informe um login" 
                   value="${user.login}" required>
        
            <label>Senha <span>*</span> </label> 
            <input type="password" name="senha" id="senha"placeholder="Digite uma senha" 
                   value="${user.senha}" required>
            
            <div>
                <button type="submit">Salvar</button>
                <button type="submit" onclick="cancelar()">Cancelar</button>
            </div>
        </fieldset>
    </form>

    <table>
        <caption>Lista de usuários</caption>
        <thead>
            <tr>
                <th>Código</th>
                <th>Login</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th colspan="2">Opções</th>
            </tr>
        <thead>
        <tbody>
            <!-- usuarios é o atributo que vem com a lista de usuarios do UsuarioServlet -->
            <c:forEach items="${usuarios}" var="user">
              <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.nome}" /></td>
                <td><c:out value="${user.telefone}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td><a href="salvarUsuario?acao=editar&user=${user.id}">Editar</a></td>
                <td><a href="salvarUsuario?acao=delete&user=${user.id}">Excluir</a></td>
              </tr>
            </c:forEach>
        </tbody>
  </table>
  
  <script type="text/javascript">
      function cancelar() {
    	  document.querySelector("form").action = "salvarUsuario?acao=reset";
      }
  </script>
</body>
</html>