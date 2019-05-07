<%@page import="br.usjt.web.projetointegrado.model.Noticia"%>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<%@include file="/Includes/header.jsp" %>
<title>Esqueci minha senha</title> 
</head>
<body class="fonte">
<%@include file="/Includes/navBar.jsp" %>
<div class="row justify-content-md-center align-items-center espaco">
	<div class="col-md-6 text-center">
	<%if(request.getSession() == null || request.getSession().getAttribute("usuario") == null){ %>
		<h3> Para recuperar a senha preencha o campo abaixo:</h3>
	<%} %>
	</div>
</div>
<form action="recuperacao.do" method="post">
	<div class="form-group row justify-content-md-center">
		<div class="col-md-4">
			<label for="email" class="badge badge-info">E-mail</label>
			<input type="email" id="email" name="email" class="form-control fonte"  placeholder="Digite seu e-mail" required/>	
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-md-1">
			<input type="submit" class="btn btn btn-dark" value="Recuperar senha">
		</div>
	</div>
</form>
</body>
</html>