<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
<h1>receber-nome.jsp</h1>
<strong>Recebendo parâmetro do forward: </strong>
<%= request.getParameter("paramforward") %>
<br>
<%=	
	/* String nome = "Nome recebido: " + request.getParameter("nome");
	out.print(nome);  */
	
	/* tag expressão, simbolo de =, faz com que não seja preciso escrever o java puro para exibir em tela */
	/*request: objeto implícito que faz parte do jsp e do servidor e é uma implementação da interface HttpServletRequest*/
	"Nome recebido: " + request.getParameter("nome") /*Não precisa e não deve ser usado ; em tag de expressão*/
	
%>
<br>
<h1>Alguns request methods</h1>
<!-- Alguns métodos do objeto implícito request -->
<%= "Endereço do contexto: " + request.getContextPath() %>
<br>
<%= "Porta Local: " + request.getLocalPort() %>
<br>
<%= "Nome local: " + request.getLocalName() %>
<br>
<%= "Endereço local: " + request.getLocalAddr() %>
<br>
<%= "Nome do servlet: " + request.getServletPath() %>
<br>
<%= "Tipo de método da requisição: " +  request.getMethod() %>
<br>
<%= "Tipo de protocolo: " + request.getProtocol() %>
<br>
<%= "Query String: " + request.getQueryString() %>
<br>
<%= "URI de requisição: " + request.getRequestURI() %>
<br>
<%= "ID de sessão: " + request.getRequestedSessionId()%>
<br>
<%= "Esquema: " + request.getScheme() %>
<br>
<h1>Alguns response methods</h1>
<%= "Tipo de conteúdo: " + response.getContentType() %>
<br>
<%= "Tamanho do buffer: " + response.getBufferSize()%>
<br>
<%= "Codificação de caractere: " + response.getCharacterEncoding()%>
<br>
<%= "Valor header content-type: " + response.getHeader("content-type")%>
<br>
<%= "Status de resposta: " + response.getStatus()%>
<br>
<%= "Localização: " + response.getLocale()%>
<br>
<!-- Ao clicar em enviar no index.jsp, redireciona para o youtube -->
<% /*response.sendRedirect("https://www.youtube.com/"); */ %>
<br>
<br>
<%! /*Tag de declaração: */
	int cont = 2;
	public int retornatriplo(int numero) {
		return numero * 3;
	}
%>
<br>
<%=
	"Conteudo da variável cont: " + cont
%>
<br>
<%="triplo do número passado é: " + retornatriplo(8)%>
<h1>Application get init parameter (fica no web.xml)</h1>
<%= application.getInitParameter("Estado") %>
<h1>Resgatando atributo de sessão, definido em index.jsp</h1>
<%= "Valor do atributo de sessão curso: " + session.getAttribute("curso") %>
<br>
<!-- Essa será uma página que vai receber o erro de divisão por zero de index.jsp -->
<strong>Recebendo exceção de divisão por zero de index.jsp: </strong>
<%@ page isErrorPage="true" %>
<%= exception %>

</body>

</html>