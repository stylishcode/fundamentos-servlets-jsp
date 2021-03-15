<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login | JSP</title>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css">
  <link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>

<body>
  
  <%-- <!-- Tag JSTL de saída -->
  <c:out value="${'Bem vindo ao JSTL'}" /><br>
  <!-- Tag JSTL de importação -->
  <c:import var="google_html" url="https://www.google.com.br" />
  <!-- Tag JSTL de remoção de variável -->
  <c:remove var="google_html"/>
  <c:out value="${google_html}" /> <!-- Como foi removida, ela não vai mostrar a var google_html -->
  <!-- Tag JSTL de declaração de variável -->
  <c:set var="variavel" scope="page" value="${500 * 6}"/>
  <c:out value="${variavel}" />
  <!-- Tag JSTL para captura de exceção -->
  <br>
  <c:catch var="erro">
    <% int var = 100/0; %>
  </c:catch>
  <!-- Tags JSTL condicionais-->
  <c:if test="${erro != null}"> <!-- Se existir erro no catch acima -->
    ${erro.message}
  </c:if>
  <br>
  <c:set var="numero" value="${100/3}"/>
  
  <c:choose>
    <c:when test="${numero > 50}">
      <c:out value="${'Maior que 50'}" />
    </c:when>
    
    <c:when test="${numero < 50}">
      <c:out value="${'Menor que 50'}" />
    </c:when>
    
    <c:otherwise>
      <c:out value="${'Não encontrou valor correto'}" />
    </c:otherwise>
  </c:choose>
  <br>
  <!-- Tag JSTL for each/for -->
  <c:forEach var="n" begin="1" end="${numero}">
     Item: ${n}
  </c:forEach>
  <br>
  <!-- Tag quebra de string por delimitador -->
  <c:forTokens items="Matheus-Enrique-Pena-Pereira" delims="-" var="nome">
     <br>
     Nome: ${nome}
  </c:forTokens>
  <!-- Tag URL (Útil para montar urls) -->
  <br>
  <c:url value="/acessoliberado.jsp" var="acesso">
    <c:param name="param1" value="111" />
    <c:param name="param2" value="222"></c:param>
  </c:url>
  ${acesso}
  <!-- Tag redirecionamento -->
  <c:if test="${numero > 50}">
    <c:redirect url="https://www.google.com.br" />
  </c:if>
  
  <p />
  <p />
  <p />
  <p /> --%>

  <form action="LoginServlet" method="post">
    <input type="text" id="login" name="login" placeholder="Login"">
    <input type="password" id="senha" name="senha" placeholder="Senha"">
    <button type="submit">Entrar</button>
  </form>
  
</body>

</html>