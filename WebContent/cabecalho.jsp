<jsp:useBean 
    id="calcula" 
    class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" 
	scope="page" 
/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- Recebendo todas as propriedades do Java bean com id calcula -->
	<jsp:setProperty property="*" name="calcula" />
	<h1>Cabeçalho</h1>
	
	<strong>Recuperando dados que foram enviados do formulário para o Java Bean com id calcula</strong>
	<br>
	<!-- Pegando a propriedade nome, ano e sexo do Java bean com id calcula através do jsg:getProperty -->
	<%-- <jsp:getProperty property="nome" name="calcula" /> --%>
    <!-- Pegando a propriedade nome, ano e sexo atráves de jsp expressions (muito utilizado) -->
    Nome: ${ param.nome }
	<br>
	<%-- <jsp:getProperty property="ano" name="calcula" /> --%>
	Ano: ${ param.ano }
	<br>
	<%-- <jsp:getProperty property="sexo" name="calcula" /> --%>
	Sexo: ${ param.sexo }
	<br>
	Atributo de sessão: ${ sessionScope.user }
	
</body>

</html>