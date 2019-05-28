<%@include file="/Includes/HeaderAdmin.jsp" %>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<title>Consultar banca</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h1>Consultar Banca</h1>
		</div>
	</div>
	<form action="Consultar.do"  method="post">
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="grupo" class="badge badge-info" >Grupo </label>
			    <input type="text" name="grupo" class="form-control  fonte" id="grupo" placeholder="Digite o grupo" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="sala" class="badge badge-info">Sala</label>
			    <input type="text" name="sala" class="form-control  fonte" id="sala" placeholder="Digite a sala" maxlength="25" required>
		    </div>
		</div>
		<div class="form-group row justify-content-md-center" class="hopeTo">
		  	<div class="col-md-4">
			    <label for="data" class="badge badge-info">Data</label>
			    <input type="text" name="data" class="form-control fonte" id="data" placeholder="Digite a data" maxlength="25" required>
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