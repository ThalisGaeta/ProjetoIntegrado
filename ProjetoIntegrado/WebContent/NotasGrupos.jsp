<%@page import="br.usjt.web.projetointegrado.dao.GrupoDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Grupo"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Notas dos Grupos</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Notas dos grupos</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3"> 
			<select class="select-dropdown dropdown-trigger">
				<option disabled selected>Escolha a classe</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
			</select>
		</div>
		<div class="col-md-3 offset-md-3"> 
			<select class="select-dropdown dropdown-trigger">
				<option disabled selected>Escolha o grupo</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover ">
			  <thead>
			    <tr>
			      <th scope="col">R.A.</th>	
			      <th scope="col">Nome</th>

			      <th scope="col">Entrega 1</th>
			      <th scope="col">Entrega 2</th>
				  <th scope="col">Média</th>
				  <th scope="col">Alterar nota</th>
			      
			    </tr>
			  </thead>
			  <tbody>

				<tr>
			      <th scope="row" class="text-center"></th>
			      <td class="text-center"></td>
			      <td class="text-center"></td>
			      <td class="text-center"></td>
			      

			      <td></td>
			      <td>
			      <!-- aqui é onde não tem o java feito "listarnotasgrupos" --> 
			      
				      <form action="ListarNotasGrupos.do" method="get" id="id2">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2').submit();"></a>
				      		<label><input type="checkbox" value="" id="codigoGrupo" name="codigoGrupo"> <span></span><label>
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>

				</tbody>
			</table>
		</div>
		</div>
		<div>
			<br>
			<p class="center-align">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					 <i class="material-icons center">Confirmar</i>
				</button>
			</p>
		</div>
		</div>
	<script>
		$(document).ready(function(){
    	$('select').formSelect();
  		});
	</script>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>