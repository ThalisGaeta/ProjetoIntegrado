<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Novo Professor</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Novo administrador</h4>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<form action="Cadastrar.do"  method="post">
				<div class="form-group row justify-content-md-center ">
					<div class="col-md-4">
						<label for="email" class="badge badge-info">E-mail </label>
						<input type="email" class="form-control fonte" id="email" name="email" placeholder="Digite o e-mail" required>
					</div>
				</div>
				<div class="form-group row justify-content-md-center">
				  	<div class="col-md-4">
					    <label for="nome" class="badge badge-info">Nome </label>
						<input type="text" class="form-control fonte" id="nome" name="nome" placeholder="Digite o nome" required>
					</div>
				</div>
				<div class="form-group row justify-content-md-center">
				  	<div class="col-md-4">
					    <label for="matricula" class="badge badge-info">Matricula</label>
						<input type="text" class="form-control fonte" id="matricula" name="matricula" placeholder="Digite a matricula" required>
					</div>
				</div>
				<div class="form-group row justify-content-md-center">
				  	<div class="col-md-4">
					    <label for="senha" class="badge badge-info">Senha</label>
						<input type="password" class="form-control fonte" id="senha" name="senha" placeholder="Digite a senha" required>
					</div>
				</div>
				<div class="form-group row justify-content-md-center">
					<div class="col-md-2">
						<div class="switch">
					    <label>
					      Professor
					      <input type="checkbox" name="administrador" value="administrador">
					      <span class="lever"></span>
					      Admin
					    </label>
					  </div>
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
				  	<div class="col-md-2">
						<button type="submit" class="btn btn-dark">Cadastrar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>