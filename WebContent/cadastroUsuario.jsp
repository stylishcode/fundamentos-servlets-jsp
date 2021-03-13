<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Cadastro de usuário</title>
  
  <style type="text/css">
    table {
      width: 300px;
    }
    
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
    
  </style>
</head>

<body>
  <h1>Cadastro de usuário</h1>
  
  <form action="salvarUsuario" method="post" style="margin-bottom: 10px">
    <label>Login: </label>
    <input type="text" name="login" id="login" placeholder="Informe um login" style="margin-bottom: 10px">
    <br />
    
    <label>Senha: </label>
    <input type="password" name="senha" id="senha" placeholder="Digite uma senha" style="margin-bottom: 10px">
    <br />
    
    <input type="submit" value="Salvar">
  </form>
 
  <table>
    <tr>
      <th>Login</th>
      <th>Senha</th>
    </tr>
    <!-- usuarios é o atributo que vem com a lista de usuarios do UsuarioServlet -->
    <c:forEach items="${usuarios}" var="user">
      <tr>
        <td><c:out value="${user.login}" /></td>
        <td><c:out value="${user.senha}" /></td>
        <td><a href="salvarUsuario?acao=delete&user=${user.login}">Excluir</a></td>
      </tr>
    </c:forEach>
  </table>
  
</body>

</html>