<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Cadastro de usuário</title>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css">
  <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
</head>

<body>

  <h1>Cadastro de usuário</h1>
  
  <form action="salvarUsuario" method="post">
    <input type="text" name="id" id="id" readonly="readonly" placeholder="Gerado automaticamente" value="${user.id}"
    	   class="hidden-input-id">
    
    <label>Login <span>*</span></label>
    <input type="text" name="login" id="login" placeholder="Informe um login" value="${user.login}">
    
    <label>Senha <span>*</span></label>
    <input type="password" name="senha" id="senha" placeholder="Digite uma senha" value="${user.senha}">
    
    <button type="submit">Salvar</button>
  </form>
 
  <table>
    <tr>
      <th>Código</th>
      <th>Login</th>
      <th>Senha</th>
      <th colspan="2">Opções</th>
    </tr>
    <!-- usuarios é o atributo que vem com a lista de usuarios do UsuarioServlet -->
    <c:forEach items="${usuarios}" var="user">
      <tr>
        <td><c:out value="${user.id}" /></td>
        <td><c:out value="${user.login}" /></td>
        <td><c:out value="${user.senha}" /></td>
        <td><a href="salvarUsuario?acao=delete&user=${user.id}">Excluir</a></td>
        <td><a href="salvarUsuario?acao=editar&user=${user.id}">Editar</a></td>
      </tr>
    </c:forEach>
  </table>
  
</body>

</html>