<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciamento de Países</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<c:import url="Menu.jsp"/>
    <div id="main" class="container">
        <h3 class="page-header">Gerenciamento de Países</h3>

        <form action="ManterPais.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome"  placeholder="Nome do país">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="populacao">População</label>
                    <input type="text" class="form-control" name="populacao" id="populacao"  placeholder="Digite a população">
                </div>

                <div class="form-group col-md-6">
                    <label for="area">Área</label>
                    <input type="text" class="form-control" name="area" id="area"  placeholder="Digite a área">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
                    <button type="button" class="btn btn-primary" name="acao" data-target="#alterarModal" data-toggle="modal">Alterar</button>
                    <button type="button" class="btn btn-primary" name="acao" data-target="#excluirModal" data-toggle="modal">Excluir</button>
                    <button type="submit" class="btn btn-primary" name="acao" value="Listar">Listar</button>
                    <button type="submit" class="btn btn-primary" name="acao" value="100k">Países 100k</button>                 
                    <a href="index.html" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    
    <div class="modal fade" id="alterarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Alterar País</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        
        <div class="modal-body">
          <form method="post" action="ManterPais.do">
          		<div class="row">
                <div class="form-group col-md-6">
                	  <label for="inputFirstName">ID:</label>
                	<input type="text" class="form-control" name="idAlterar" placeholder="">
                </div>
                <div class="form-group col-md-6">
                	  <label for="inputFirstName">Nome:</label>
                	<input type="text" class="form-control" name="nomeAlterar" placeholder="">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                	  <label for="inputFirstName">Populacao:</label>
                	<input type="text" class="form-control" name="populacaoAlterar" placeholder="">
                </div>
                <div class="form-group col-md-6">
                	  <label for="inputFirstName">Area:</label>
                	<input type="text" class="form-control" name="areaAlterar" placeholder="">
                </div>
               </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary dedo" data-dismiss="modal">Sair</button>
          <button type="submit" class="btn btn-primary dedo" name="acao" value="alterar">Alterar</button>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>
    
    <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Excluir País</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        
        <div class="modal-body">
          <form method="get" action="ManterPais.do">
              
                <div class="">
                	  <label for="inputFirstName">ID:</label>
                	<input type="text" class="form-control" name="idPais">
                </div>
               
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary dedo" data-dismiss="modal">Sair</button>
          <button type="submit" class="btn btn-primary dedo" name="acao" value="excluir">Excluir</button>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>