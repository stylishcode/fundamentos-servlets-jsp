<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sistema JSP | Início</title>
</head>

<body>
  <h2>Seja bem vindo ao sistema em JSP</h2>
  <!-- Ao clicar, ele manda o parametro listartodos que carrega a lista de usuários -->
  <a href="salvarUsuario?acao=listartodos" alt="Cadastro de usuários">
    <img alt="Cadastro de usuários" title="Cadastro de usuários" src="resources/img/user-female-icon.png"
         style="width: 120px; height: 120px"
    >
  </a>
  
  <a href="cadastroProduto.jsp" alt="Cadastro de Produtos">
    <img alt="Cadastro de produtos" title="Cadastro de produtos" src="resources/img/adicionar-produto.png"
         style="width: 120px; height: 120px"
    >
  </a>
  
  <a href="salvarProduto?acao=listarProdutos" alt="Lista de produtos">
    <img alt="Lista de produtos" title="Lista de produtos" src="resources/img/icone-produto.png"
         style="width: 120px; height: 120px"
    >
  </a>
  
</body>

</html>