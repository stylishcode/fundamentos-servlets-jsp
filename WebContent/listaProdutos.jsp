<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/tabela.css">
</head>
<body>
    <div class="container">
        <div style="position: absolute; left: 1240px; bottom: 630px">
            <a style="padding:0.94rem 0.5rem;background:#4b99ad;color: #ffffff;cursor: pointer; margin-right: 0.5rem" 
               href="acessoliberado.jsp"
            >
                Início
            </a>
               
            <a style="padding:0.94rem 0.5rem;background:#4b99ad;color: #ffffff;cursor: pointer;" 
               href="indexLogin.jsp"
            >
                Sair
            </a>
        </div>
        
        <table>
            <caption>Lista de produtos</caption>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td><c:out value="${produto.id}"/></td>
                        <td><c:out value="${produto.nome}"/></td>
                        <td><c:out value="${produto.quantidade}"/></td>
                        <td><c:out value="${produto.valor}"/></td>
                        <td><a href="salvarProduto?acao=editar&produto=${produto.id}">Editar</a></td>
                        <td><a href="salvarProduto?acao=delete&produto=${produto.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>