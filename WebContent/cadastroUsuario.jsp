<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Cadastro de usuário</title>
</head>

<body>
  <h1>Cadastro de usuário</h1>
  
  <form action="salvarUsuario" method="post">
    <label>Login: </label>
    <input type="text" name="login" id="login" placeholder="Informe um login" style="margin-bottom: 10px">
    <br />
    
    <label>Senha: </label>
    <input type="password" name="senha" id="senha" placeholder="Digite uma senha" style="margin-bottom: 10px">
    <br />
    
    <input type="submit" value="Salvar">
  </form>
  
</body>

</html>