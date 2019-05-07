<%@page import="br.usjt.web.projetointegrado.dao.NoticiaDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%!public ArrayList<Noticia> listarNoticias(){
	NoticiaDAO dao = new NoticiaDAO();
	ArrayList<Noticia> noticias = null;
	try{
		noticias = dao.consultar();
		return noticias;
	}catch(Exception e){
		return noticias;
	}
}%>
<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Listar noticias</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Lista de todas as noticias</h4>
		</div>
	</div>
	<%if (request.getAttribute("excluirNoticia") != null) {%>
	<div class="form-group row justify-content-md-center">
		<div class="col-md-6">
			<div class="collection text-center">
				<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("excluirNoticia")); %></h5></a>
			</div>
		</div>
	</div>
	<%}%>
	<div class="row">
		<div class="col">
			<table class="table table-hover ">
			  <thead>
			    <tr>
			      <th scope="col">Codigo</th>
			      <th scope="col">Titulo</th>
			      <th scope="col">Resumo</th>
			      <th scope="col">Editar</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%ArrayList<Noticia> noticias = listarNoticias();
			  	if(noticias != null){
					while(!noticias.isEmpty()){ 
				%>
				<tr>
			      <th scope="row" class="text-center"><%out.println(noticias.get(0).getId()); %></th>
			      <td class="text-center"><%out.println(noticias.get(0).getTitulo()); %></td>
			      <td><%out.println(noticias.get(0).getResumo()); %></td>
			      <td>
				      <form action="ExcluirNoticia.do" method="post" id="id1<%=noticias.get(0).getId()%>">
					      <a href="#!" class="material-icons corA" onClick="document.getElementById('id1<%=noticias.get(0).getId()%>').submit();">clear</a>
							<input type="number" style="display:none;" value="<%=noticias.get(0).getId()%>" id="codigoNoticia" name="codigoNoticia" >
				      		<button type="submit" style="display:none;"></button>
				      </form> 
				      <form action="ListarNoticias.do" method="get" id="id2<%=noticias.get(0).getId()%>">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2<%=noticias.get(0).getId()%>').submit();">edit</a>
				      		<input type="number" style="display:none;" value="<%=noticias.get(0).getId()%>" id="codigoNoticia" name="codigoNoticia">
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>
				<%	noticias.remove(0);}
				}else{
				%>
				<tr>
					<th></th>
					<th class="text-center">Nenhuma noticia cadastrada!</th>
				</tr>
				<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>