<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de produtos</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
</head>
<body>
    <div class="container">
        <form action="salvarProduto" method="post">
            <fieldset>
                <legend>Cadastro de Produtos</legend>
                <input type="text" name="id" id="id" value="${produto.id}">
                <input type="text" name="nome" id="nome" value="${produto.nome}" required>
                <input type="text" name="quantidade" id="quantidade" value="${produto.nome}" required>
                <input type="text" name="valor" id="quantidade" value="${produto.quantidade}" required>
                
                <button type="submit">Salvar</button>
            </fieldset>
        </form>
    </div>
</body>
</html>