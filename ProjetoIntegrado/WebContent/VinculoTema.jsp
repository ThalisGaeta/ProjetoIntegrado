<%@page import="br.usjt.web.projetointegrado.dao.TemaDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Tema"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/Includes/HeaderAdmin.jsp"%>
<title>Listar Temas</title>
</head>
<body class="fonte">
	<%@include file="/Includes/navBarAdmin.jsp"%>
	<div class="container mt-5">
		<div class="row justify-content-md-center espaco">
			<div class="col-md-6 text-center">
				<h4>Vincular Temas às turmas</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<select class="select-dropdown dropdown-trigger">
					<option disabled selected>Escolha o tema</option>
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
					<option disabled selected>Escolha a turma</option>
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
							<th scope="col">Titulo</th>
							<th scope="col">Introdução</th>
							<th scope="col">Requisitos</th>
							<th scope="col">Selecionar</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<th scope="row" class="text-center"></th>
							<td class="text-center"></td>
							<td></td>
							<td>
								<form action="ListarTemas.do" method="get" id="id2">
									<a href="#!" class="material-icons corA"
										onClick="document.getElementById('id2').submit();"></a> <label><input
										type="checkbox" value="" id="codigoTema" name="codigoTema">
										<span></span><label>
											<button type="submit" id="editarNoticia"
												style="display: none;"></button>
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
							<th scope="col">Semestre</th>
							<th scope="col">Ano</th>
							<th scope="col">Sigla</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<th scope="row" class="text-center"><label> <input
									name="group1" type="radio" checked /> <span></span>
							</label></th>
							<td class="text-center"></td>
							<td></td>
							<td>

								<form action="ListarTurmas.do" method="get" id="id2">
									<a href="#!" class="material-icons corA"
										onClick="document.getElementById('id2').submit();">edit</a> <input
										type="number" style="display: none;" value="" id="codigoTurma"
										name="codigoTurma">
									<button type="submit" id="editarNoticia" style="display: none;"></button>
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
	<%@include file="/Includes/FooterAdmin.jsp"%>
</body>
</html>