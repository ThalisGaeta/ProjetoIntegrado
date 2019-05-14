<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Editar Projeto</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Editar um temas</h4>
		</div>
	</div>
	<form action="ListarNoticias.do"  method="get">
		<div class="row">
			<div class="col">
					<div class="form-group row justify-content-md-center ">
					  	<div class="col-md-4">
							<label for="codigoTema" class="badge badge-info">Código do tema</label>
							<% Noticia noticia = (Noticia)request.getAttribute("UmaNoticia"); %>
							<script >
							<% if(noticia != null){%>
							console.log(<%out.println(noticia.getId());%>);
							<%}%>
							</script>
							<% if(noticia != null){%>
						  	<input type="number" class="form-control fonte" value="<%=noticia.getId()%>" id="codigoTema" name="codigoTema" placeholder="Digite o código do tema" required>
						  	<%}else {%>
						  	<input type="number" class="form-control fonte" id="codigoTema" name="codigoTema" placeholder="Digite o código do tema" required>
						  	<%} %>
						</div>
					</div>
				
			</div>
		</div>
		<div class="row justify-content-md-center text-center">
			<div class="col-md-2">
				<button type="submit" class="btn btn-dark btn-sm">Buscar</button>
			</div>
		</div>
	</form>
	<div class="row">
		<div class="col">
			<form action="AtualizarNoticia.do"  method="post">
			  	<div class="form-group row justify-content-md-center ">
			  		<div class="col-md-4">
				    	<label for="tituloTema" class="badge badge-info">Titulo do tema </label>
						<% if(noticia != null){%>
					  	<input type="text" class="form-control fonte" id="tituloTema" name="tituloTema" placeholder="Digite o titulo do tema" maxlength="40" value="<%=noticia.getTitulo() %>" required>
					  	<%}else {%>
					  	<input type="text" class="form-control fonte" id="tituloTema" name="tituloTema" placeholder="Digite o titulo do tema" maxlength="40" required>
					  	<%} %>
					</div>
			  	</div>
			  	<div class="form-group row justify-content-md-center">
				<div class="col-md-4">
				    <label for="introducaoTema" class="badge badge-info">Introdução do tema</label>
				    	<% if(noticia != null){%>
					  	<textarea id="introducaoTema" name="introducaoTema" class="materialize-textarea fonte" placeholder="Digite o resumo do tema" maxlength="316" required><%=noticia.getResumo()%></textarea>
					  	<%}else {%>
					  	<textarea id="introducaoTema" name="introducaoTema" class="materialize-textarea fonte" placeholder="Digite o resumo do tema" maxlength="316" required></textarea>
					  	<%} %>
				</div>
				</div>
				<div class="form-group row justify-content-md-center">
					<div class="col-md-4">
						<label for="requisitoTema" class="badge badge-info">Requisitos do tema</label>
				    	<% if(noticia != null){%>
					  	<textarea id="requisitoTema" name="requisitoTema" class="materialize-textarea fonte" placeholder="Digite os requisitos do tema" maxlength="8000" required><%=noticia.getConteudo()%></textarea>
					  	<%}else {%>
					  	<textarea id="requisitoTema" class="materialize-textarea fonte" placeholder="Digite os requisitos do tema" maxlength="8000" required></textarea>
					  	<%} %>
    				</div>
				</div>
				<% if(noticia != null){%>
				<input type="hidden" name="codigoNoticia" value="<%=noticia.getId()%>" hide>
				<%} %>
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
						<button type="submit" class="btn btn-dark">Atualizar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>