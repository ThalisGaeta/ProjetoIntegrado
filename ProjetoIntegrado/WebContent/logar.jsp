<%@page import="br.usjt.web.projetointegrado.model.Noticia"%>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<%@include file="/Includes/header.jsp" %>
<title>Login</title> 
</head>
<body class="fonte">
<%@include file="/Includes/navBar.jsp" %>
	<div class="row justify-content-md-center align-items-center espaco">
	  	<div class="col-md-6 text-center">
	<%if(request.getSession() == null || request.getSession().getAttribute("usuario") == null){ %>
				<h1> Bem vindo ao Sistema de</h1><h1> Projeto Integrado </h1>
	<% }else if( request.getSession().getAttribute("usuario") != null) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
					if(usuario.getPerfil() == 1 ){%>
					<h1>Você já esta logado, <% out.println(usuario.getNome()); %>!</h1>
					<a href="indexAdmin.jsp" class="btn btn-dark">Pagina administrativa</a>
			<%}else{ %>
					<h1>Você já esta logado, <% out.println(usuario.getNome()); %>!</h1>
			<%} %>
	<% }%>
		</div>
	</div>
	<%if(request.getSession() == null || request.getSession().getAttribute("usuario") == null){ %>
	<form action="Login.do" method="post">
	<div class="form-group row justify-content-md-center">
		<div class="col-md-4">
			<label for="email" class="badge badge-info">E-mail</label>
			<input type="email" id="email" name="email" class="form-control fonte"  placeholder="Digite seu e-mail" required/>	
		</div>
	</div>
	<div class="form-group row justify-content-md-center">
		<div class="col-md-4">
			<label for="senha" class="badge badge-info">Senha</label>
			<input type = "password" id="senha" name="senha" class="form-control fonte"  placeholder="Digite sua senha" required/>
			<small id="emailHelp" class="form-text text-center"><a href="esqueciSenha.jsp" class="corA">Esqueci minha senha</a></small>
		</div>
	</div>
		<%}if (request.getAttribute("erro") != null) {%>
	<div class="form-group row justify-content-md-center">
		<div class="col-md-4">
			<div class="collection text-center">
				<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("erro")); %></h5></a>
			</div>
		</div>
	</div>
	<%}%>
	<div class="row justify-content-md-center">
	<%if(request.getSession().isNew() || request.getSession().getAttribute("usuario") == null){ %>
	  	<div class="col-md-2">
			<input type="submit" class="btn btn btn-dark" value="Entrar">
		</div>
	<%}  %>
	<%if (request.getAttribute("erro") != null && request.getAttribute("erro").equals("Você precisa estar logado para comentar!")) { %>
		<div class="col-md-2">
		<%Integer idNoticia = (Integer)request.getAttribute("idNoticia"); %>
		<%if(idNoticia != null){%>
			<form action="LerNoticia.do" method="get" id="id<%=idNoticia%>">
				<a href="#!" class="btn btn-dark" onClick="document.getElementById('id<%=idNoticia%>').submit();">Voltar
				<input type="number" style="display:none;" value="<%=idNoticia %>" id="codigoNoticia" name="codigoNoticia" >
				<input type="submit" style="display:none;"></a>
			</form>
		
	<%}}else{ %>
			<a href="Index.jsp" class="btn btn-dark">Voltar</a>
	<%} %>
		</div>
	</div>
	</form>
	
</body>
</html>
