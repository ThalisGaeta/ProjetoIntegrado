<%@page import="br.usjt.web.projetointegrado.dao.NoticiaDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.usjt.web.projetointegrado.model.Usuario"%>
<%!public ArrayList<Noticia> listarNoticias(){
	NoticiaDAO dao = new NoticiaDAO();
	ArrayList<Noticia> noticias = null;
	try{
		noticias = dao.consultar();
		return noticias;
	}catch(Exception e){
		return noticias;
	}
}
%>
<%@include file="/Includes/header.jsp" %>
<title>Real News</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBar.jsp" %>
<div class="container topo">
	<%ArrayList<Noticia> noticias = listarNoticias();
	if(noticias != null){
		int i = 1; 
		while(!noticias.isEmpty()){
		if(i%2!=0){
	%>
	<div class="row">
		<div class="col-md-5 com-borda tamanho">
		<form action="LerNoticia.do" method="get" id="id<%=noticias.get(0).getId()%>"> 
			<a class="semDeco" href="#!" onClick="document.getElementById('id<%=noticias.get(0).getId()%>').submit();">
				<span class="link-div">
					<h4 class="text-center"><%out.println(noticias.get(0).getTitulo()); %></h4>
					<p class="text-justify p-2"><%out.println(noticias.get(0).getResumo()); %>
					 </p> 
					 <spam class="pl-1">Clique para continuar lendo...<spam>
				 </span>
			</a>
		<input type="number" style="display:none;" value="<%=noticias.get(0).getId()%>" id="codigoNoticia" name="codigoNoticia" >
		<input type="submit" style="display:none;">
		</form>
		</div>
	<%	noticias.remove(0);i++;}else{ %>
		<div class="col-md-5 offset-md-2 com-borda tamanho">
		<form action="LerNoticia.do" method="get" id="id<%=noticias.get(0).getId()%>"> 
			<a class="semDeco" href="#!" onClick="document.getElementById('id<%=noticias.get(0).getId()%>').submit();">
				<span class="link-div">
					<h4 class="text-center"><%out.println(noticias.get(0).getTitulo()); %></h4>
					<p class="text-justify p-2">
					<%out.println(noticias.get(0).getResumo()); %>
					</p>
					<spam class="pl-1">Clique para continuar lendo...<spam>
				 </span>
			</a>
		<input type="number" style="display:none;" value="<%=noticias.get(0).getId()%>" id="codigoNoticia" name="codigoNoticia" >
		<input type="submit" style="display:none;">
		</form>
		</div>
	</div>
	<%	noticias.remove(0);i++;}
		}
	}else{%>
	<h2 class="text-center">Oops... Estamos sem projetos!</h2>
	<%} %>
</div>


</body>
</html>