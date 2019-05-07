<%@page import="java.util.ArrayList"%>
<%@page import="br.usjt.web.projetointegrado.model.Comentario"%>
<%@page import="br.usjt.web.projetointegrado.model.Noticia"%>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<%@include file="/Includes/header.jsp" %>
<title> Real News</title> 
</head>
<body class="fonte">
<%@include file="/Includes/navBar.jsp" %>
<% Noticia noticia = (Noticia)request.getAttribute("UmaNoticia");%>
<div class="container topo">
	<div class="row">
	<%if(noticia != null){ 
		request.getSession().setAttribute("noticia", noticia);%>
		<div class="col-md-12 com-borda">
			<h1 class="text-center">
				<%=noticia.getTitulo() %>
			</h1>
			<p class="text-justify p-2">
				<%=noticia.getConteudo() %>
			</p>
			
		</div>
	<%} else if(request.getAttribute("erro") != null){ %>
		<div class="col-md-12 com-borda">
			<div class="collection text-justify p-2">
				<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("erro")); %></h5></a>
			</div>
		</div>
	</div>
	<%}else{ %>
			<div class="col-md-12 com-borda">
			<div class="collection text-justify p-2">
				<a href="#!" class="collection-item text-center"><h5>Não temos nada sobre essa noticia! :(</h5></a>
			</div>
		</div>
	</div>
	<%} %>	
	</div>
	<div class="row">
		<h4 class="pl-3"> Comentarios:</h4>
	</div>
	<div class="row">
		<% Comentario comentario = new Comentario();
			ArrayList<Comentario> comentarios = (ArrayList<Comentario>)request.getAttribute("comentarios");
		%>
		<%if(comentarios == null){ %>
			<div class="col-md-12 com-borda m-2">
				<h3 class="text-center">Não tem nenhum comentario nesta noticia ):</h3>
			</div>
		<%}else {%>
			<%while(!comentarios.isEmpty()){ %>
			<div class="col-md-12 com-borda m-2">
				<h6 class="text-left"><%=comentarios.get(0).getNome() %> comentou :</h6>
				<p class="text-justify"><%=comentarios.get(0).getComentario() %></p>
			</div>
			<%comentarios.remove(0);} %>
		<%} %>
		
	</div>
	<%if(request.getAttribute("meuComentario") != null){ %>
		<div class="col-md-12 com-borda">
			<div class="collection text-justify p-2">
				<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("meuComentario")); %></h5></a>
			</div>
		</div>
	<%} %>
	<form action="Comentar.do"  method="post">
			<div class="row justify-content-md-center align-items-center">
				<div class="col-md-8">
					    <label for="comentario" class="badge badge-info">Comentario</label>
    					<textarea id="comentario" name="comentario" class="materialize-textarea fonte" required></textarea>
				</div>
				<input type="number" style="display:none;" value="<%if(noticia != null){out.println(noticia.getId());}%>" id="codigoNoticia" name="codigoNoticia" >
			  	<div class="col-md-2">
				  <button type="submit" class="btn btn-dark btn-small">Confirmar</button>
				</div>
			</div>
	</form>
</body>
</html>