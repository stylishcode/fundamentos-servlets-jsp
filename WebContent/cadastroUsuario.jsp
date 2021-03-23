<%@page
  import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de usuário</title>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
    <link rel="stylesheet" type="text/css" href="resources/css/tabela.css"
</head>

<body>
    <form action="salvarUsuario" method="post">
        <fieldset>
            <legend>Cadastro de usuários</legend>
            
            <h3 style="margin-bottom: 0.35rem; color: orange">${msg}</h3>
            
            <input type="text" name="id" id="id" readonly="readonly" placeholder="Gerado automaticamente" 
                   value="${user.id}" class="hidden-input-id"> 
                   
            <label>Nome <span>*</span></label>
            <input type="text" name="nome" id="nome" placeholder="Nome" 
                   value="${user.nome}" required>
                   
            <label>Telefone <span>*</span></label>
            <input type="tel" name="telefone" id="telefone" placeholder="Telefone" 
                   value="${user.telefone}" required>
        
            <label>Login <span>*</span></label>
            <input type="text" name="login" id="login" placeholder="Informe um login" 
                   value="${user.login}" required>
        
            <label>Senha <span>*</span> </label> 
            <input type="password" name="senha" id="senha" placeholder="Digite uma senha" 
                   value="${user.senha}" required>
                   
            <label>IBGE <span>*</span> </label> 
            <input type="text" name="ibge" id="ibge" placeholder="Informe o IBGE" 
                   value="${user.ibge}" required>
            
            <label>CEP <span>*</span> </label> 
            <input type="text" name="cep" id="cep" placeholder="Informe o CEP" 
                   value="${user.cep}" required>
                   
            <label>Rua <span>*</span> </label> 
            <input type="text" name="rua" id="rua" placeholder="Informe a Rua" 
                   value="${user.rua}" required>
                   
            <label>Bairro <span>*</span> </label> 
            <input type="text" name="bairro" id="bairro" placeholder="Informe o bairro" 
                   value="${user.bairro}" required>
                   
            <label>Cidade <span>*</span> </label> 
            <input type="text" name="cidade" id="cidade" placeholder="Informe a cidade" 
                   value="${user.cidade}" required>
            
            <label>Estado <span>*</span> </label> 
            <input type="text" name="estado" id="estado" placeholder="Informe o estado" 
                   value="${user.estado}" required>     
            
            <div>
                <button type="submit">Salvar</button>
                <button type="submit" onclick="cancelar()">Cancelar</button>
            </div>
        </fieldset>
    </form>
    
    <div class="container-table">
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
            <caption>Lista de usuários</caption>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Login</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>IBGE</th>
                    <th>CEP</th>
                    <th>Rua</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th colspan="2">Opções</th>
                </tr>
            <thead>
            <tbody>
                <!-- usuarios é o atributo que vem com a lista de usuarios do UsuarioServlet -->
                <c:forEach items="${usuarios}" var="user">
                  <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nome}" /></td>
                    <td><c:out value="${user.telefone}" /></td>
                    <td><c:out value="${user.login}" /></td>
                    <td><c:out value="${user.ibge}" /></td>
                    <td><c:out value="${user.cep}" /></td>
                    <td><c:out value="${user.rua}" /></td>
                    <td><c:out value="${user.bairro}" /></td>
                    <td><c:out value="${user.cidade}" /></td>
                    <td><c:out value="${user.estado}" /></td>
                    <td><a href="salvarUsuario?acao=editar&user=${user.id}">Editar</a></td>
                    <td><a href="salvarUsuario?acao=delete&user=${user.id}">Excluir</a></td>
                  </tr>
                </c:forEach>
            </tbody>
      </table>
    </div>
   
  <script type="text/javascript">
      function cancelar() {
    	  document.querySelector("form").action = "salvarUsuario?acao=reset";
      }
  </script>
</body>
</html>