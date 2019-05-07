<%@include file="/Includes/HeaderAdmin.jsp" %>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<title>Cadastrar aluno</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h1>Cadastrar Aluno</h1>
		</div>
	</div>
	<form action="Cadastrar.do"  method="post">
		<div class="form-group row justify-content-md-center ">
			<div class="col-md-4">
		    	<label for="email" class="badge badge-info">E-mail </label>
		    	<input type="email" name="email" class="form-control fonte" id="email" placeholder="Digite o e-mail" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="nome" class="badge badge-info" >Nome </label>
			    <input type="text" name="nome" class="form-control  fonte" id="nome" placeholder="Digite o nome" maxlength="50" required>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="senha" class="badge badge-info">Senha</label>
			    <input type="password" name="senha" class="form-control  fonte" id="senha" placeholder="Digite a senha" maxlength="25" required>
		    </div>
		</div>
		<div class="form-group row justify-content-md-center" class="hopeTo">
		  	<div class="col-md-4">
			    <label for="senha" class="badge badge-info">Repita a Senha</label>
			    <input type="password" name="senhaRepetir" class="form-control fonte" id="senhaRepetir" placeholder="Digite a senha novamente" maxlength="25" required>
		    </div>
		</div>
		<div class="form-group row justify-content-md-center">
		  	<div class="col-md-4">
			    <label for="senha" class="badge badge-info">R A </label>
			    <input type="number" name="ra" class="form-control fonte" id="ra" placeholder="Digite o RA" maxlength="10" required>
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