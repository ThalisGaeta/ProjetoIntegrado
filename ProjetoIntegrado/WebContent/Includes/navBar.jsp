<nav class="navbar navbar-light fixed-top">
	<a class="navbar-brand"><h3 class="mt-0">Projeto Integrado</h3></a>
	<div class="btn-group pb-3" role="group">
		<%
		if ( request.getSession().getAttribute("usuario") != null) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			if(usuario.getPerfil() == 0){
		%>
			<a href="#!" class="btn btn btn-dark btn-sm"><%out.println(usuario.getNome()); %></a>
			<a href="Index.jsp" class="btn btn btn-dark btn-sm">Projetos</a>
			<a href="Sair.do" class="btn btn btn-dark btn-sm">Sair</a>
		<%	}else{%>
		
			<a href="#!" class="btn btn btn-dark btn-sm"><%out.println(usuario.getNome()); %></a>
			<a href="Index.jsp" class="btn btn btn-dark btn-sm">Projetos</a>
			<a href="indexAdmin.jsp" class="btn btn btn-dark btn-sm">Menu administrativo</a>
			<a href="Sair.do" class="btn btn btn-dark btn-sm">Sair</a>
		<%	}}
		else{ %>
			<a href="logar.jsp" class="btn btn btn-dark btn-sm">login</a>
		<%} %>
	</div>	
</nav>