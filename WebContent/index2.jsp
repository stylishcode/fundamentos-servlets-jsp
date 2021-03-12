<!-- Usando um Java Bean -->
<!-- scope="page" -> Escopo somente nessa página -->
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
    <h1>Index 2</h1>
    
    <jsp:include page="cabecalho.jsp"></jsp:include>
    
    <h3>Uso de um Java Bean</h3>
    <strong>Usando o método de cálculo do Java Bean: </strong>
    <%= calcula.calcula(50) %>
    
    <h3>Enviando dados para o setter do Java Bean no cabeçalho</h3>
    <form action="cabecalho.jsp" method="post">  
        <input type="text" id="nome" name="nome" />
        <input type="text" id="ano" name="ano" />
        <input type="text" id="sexo" name="sexo" />
        <input type="submit" value="Testar" />
    </form>
    
    <h3>Atributo de sessão com expressions language JSP</h3>
    <% session.setAttribute("user", "Java avancado"); %>
    <a href="cabecalho.jsp">Ver atributo de sessão</a>
    
    <jsp:include page="rodape.jsp"></jsp:include>
</body>

</html>