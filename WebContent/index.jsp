<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Curso de JSP</title>
</head>

<body>
	<h1>Bem-vindo ao curso de JSP</h1>
	<!-- tag de script jsp (escrever java dentro da tag) -->
	<% out.print("Seu sucesso garantido"); %>
	
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome">
		<input type="submit" value="Enviar">
	</form>
	<!-- Sessão: Controla dados de variáveis e/ou dados do usuário logado, tudo o que está na sessão-->
	<% session.setAttribute("curso", "curso de jsp"); %>
</body>

</html>