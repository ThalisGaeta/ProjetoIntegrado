<%@include file="/Includes/HeaderAdmin.jsp" %>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<title>Consultar Avaliações</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h1>Consultar Avaliações</h1>
		</div>
	</div>
	<form action="Consultar.do"  method="post">
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="nome" class="badge badge-info" >Turma </label>
			    <input type="text" name="turma" class="form-control  fonte" id="turma" placeholder="Digite a turma" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="dataDeAvaliacao" class="badge badge-info">Data de Avaliação</label>
			    <input type="text" name="dataDeAvaliacao" class="form-control  fonte" id="dataDeAvaliacao" placeholder="Digite a data de avaliação" maxlength="25" required>
		    </div>
		</div>
		
		
		<%if (request.getAttribute("erro") != null) { %>
		<div class="form-group row justify-content-md-center">
			<div class="col-md-4">
				<div class="collection text-center">
					<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("erro")); %></h5></a>
				</div>
			</div>
		</div>
		<%} %>
	  <div class="row justify-content-md-center text-center">
	  	<div class="col-md-2 p-1">
		  <button type="submit" class="btn btn-dark">Consultar</button>
		</div>
		<div class="col-md-2 p-1">
		  	<a href="Index.jsp" class="btn btn-dark">Voltar</a>
		</div>
	  </div>
	</form>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>