<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de produtos</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
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
                <h3>${msg}</h3>
                
                <input type="text" name="id" id="id" value="${produto.id}" readonly="readonly" class="hidden-input-id">
                
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" value="${produto.nome}" required>
                
                <label for="quantidade">Quantidade</label>
                <input type="text" name="quantidade" id="quantidade" value="${produto.quantidade}" required>
                
                <label for="valor">Valor</label>
                <input type="text" name="valor" id="valor" value="${produto.valor}" required>
                
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