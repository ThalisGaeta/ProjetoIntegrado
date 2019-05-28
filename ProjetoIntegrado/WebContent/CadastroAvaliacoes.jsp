<%@include file="/Includes/HeaderAdmin.jsp" %>
<%@page import="br.usjt.web.projetointegrado.model.Avaliacao"%>
<title>Cadastrar avaliações</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h1>Cadastrar Avaliações</h1>
		</div>
	</div>
	<form action="Cadastrar.do"  method="post">
		<div class="form-group row justify-content-md-center ">
			<div class="col-md-4">
		    	<label for="grupo" class="badge badge-info">Grupo </label>
		    	<input type="grupo" name="grupo" class="form-control fonte" id="grupo" placeholder="Digite o grupo" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="nota" class="badge badge-info" >Nota </label>
			    <input type="text" name="nota" class="form-control  fonte" id="nota" placeholder="Digite a nota" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="Comentario" class="badge badge-info">Comentário</label>
			    <input type="comentario" name="comentario" class="form-control  fonte" id="comentario" placeholder="Digite o comentário" maxlength="100" required>
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
		  <button type="submit" class="btn btn-dark">Cadastrar</button>
		</div>
		<div class="col-md-2 p-1">
		  	<a href="Index.jsp" class="btn btn-dark">Voltar</a>
		</div>
	  </div>
	</form>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>