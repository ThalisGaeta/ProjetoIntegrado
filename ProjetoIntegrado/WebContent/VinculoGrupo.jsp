<%@page import="br.usjt.web.projetointegrado.dao.AlunoDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Aluno"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Listar Grupos</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Vincular Alunos aos grupos</h4>
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

			      <th scope="col">Selecionar</th>
			    </tr>
			  </thead>
			  <tbody>

				<tr>
			      <th scope="row" class="text-center"></th>
			      <td class="text-center"></td>
			      <td></td>
			      <td>
				      <form action="ListarAlunos.do" method="get" id="id2">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2').submit();"></a>
				      		<label><input type="checkbox" value="" id="codigoAluno" name="codigoAluno"> <span></span><label>
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>

				</tbody>
			</table>
		</div>
		<div class="col-md-6">
			<table class="table table-hover ">
			  <thead>
			    <tr>
			      <th scope="col">Escolha</th>
			      <th scope="col">Grupo</th>
			      <th scope="col">Sigla</th>
			    </tr>
			  </thead>
			  <tbody>

				<tr>
			      <th scope="row" class="text-center">
			      	<label>
        				<input name="group1" type="radio" checked />
				        <span></span>
      				</label>
      			  </th>
			      <td class="text-center"></td>
			      <td></td>
			      <td>

				      <form action="ListarAlunos.do" method="get" id="id2">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2').submit();">edit</a>
				      		<input type="number" style="display:none;" value="" id="codigoAluno" name="codigoAluno">
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