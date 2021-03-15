<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Incluir tags jsp customizadas -->
<%-- <%@ taglib prefix="minhatag-prefixo" uri="WEB-INF/testeTag.tld"%> --%>

<html>

<head>
<meta charset="UTF-8">
<title>Curso de JSP</title>
</head>

<body>
	<h1>Bem-vindo ao curso de JSP</h1>
	<h2>Index.jsp</h2>
	<!-- tag de script jsp (escrever java dentro da tag) -->
	<%
	out.print("Seu sucesso garantido");
	%>

	<!-- Diretivas JSP afetam a estrutura geral do Servlet resultante da compilação de uma página JSP. 
	Entre outras coisas, diretivas podem ser usadas para definir a linguagem usada no documento JSP, 
	arquivos a serem incluídos, bibliotecas de tags a serem usadas, etc.
    Diretivas são definidas entre as tags <%-- <%@ e %> --%> ou usando a notação XML.-->
    <%@ page info="Página do curso de JSP" %>
    <%@ page errorPage="receber-nome.jsp" %>
    
    <%@ page import="java.util.Date"%>
    <br>
    <%= "Data de hoje --> " + new Date() %>
    
    <!-- Divided By Zero error -->
    <%-- <%= 100/0 %> --%>
    
	<!-- Incluir páginas dentro de páginas -->
	<%@ include file="pagina-include.jsp" %>
	<br>
	<!-- Tag customizada, importada na linha 6 -->
	<minhatag-prefixo:MinhaTag/>
	
	<!-- Tag forward (redirecionamento de página) -->
	<jsp:forward page="receber-nome.jsp">
	   <jsp:param value="site curso de jsp avancado" name="paramforward"/>
	</jsp:forward>
	
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome"> <input type="submit"
			value="Enviar">
	</form>
	<!-- Sessão: Controla dados de variáveis e/ou dados do usuário logado, tudo o que está na sessão-->
	<%
	session.setAttribute("curso", "curso de jsp");
	%>
</body>

</html>