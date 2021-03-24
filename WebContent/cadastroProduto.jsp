<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de produtos</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
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
        
        <form action="salvarProduto" method="post">
            <fieldset>
                <legend>Cadastro de Produtos</legend>
                
                <c:if test="${erroCampos.length() > 0}">
                    <p style="position: absolute; left: 390px; bottom: 640px; color: orange">
                        Por favor, preencher: ${erroCampos}
                    </p>
                </c:if>
            
                <h3 style="margin: 0 0 0.35rem 7rem; color: orange";>${msg}</h3>
                
                <input type="text" name="id" id="id" value="${produto.id}" readonly="readonly" class="hidden-input-id">
                
                <label for="nome">Nome <span>*</span></label>
                <input type="text" name="nome" id="nome" value="${produto.nome}">
                
                <label for="quantidade">Quantidade <span>*</span></label>
                <input type="text" name="quantidade" id="quantidade" value="${produto.quantidade}">
                
                <label for="valor">Valor <span>*</span></label>
                <input type="text" name="valor" id="valor" value="${produto.valor}">
                
                <div style="display: flex;">
                    <button style="width: 180px; margin-right: 5px" type="submit">Salvar</button>
                    <button style="width: 180px" type="submit" onClick="cancelar()">Cancelar</button>
                </div>
            </fieldset>
        </form>
    </div>
    
    <script type="text/javascript">
        function cancelar() {
        	document.querySelector("form").action = "salvarProduto?acao=reset";
        }
    </script>
</body>
</html>