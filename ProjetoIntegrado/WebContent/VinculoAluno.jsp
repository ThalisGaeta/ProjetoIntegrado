<%@page import="br.usjt.web.projetointegrado.dao.AlunoDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%!public ArrayList<Aluno> listarAlunos(){
	AlunoDAO dao = new AlunoDAO();
	ArrayList<Aluno> alunos = null;
	try{
		alunos = dao.consultarAlunos();
		return alunos;
	}catch(Exception e){
		return null;
	}
}%>
<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Listar Alunos</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Vincular Alunos as turmas</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3"> 
			<select class="select-dropdown dropdown-trigger">
				<option disabled selected>Escolha o ano</option>
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
				<option disabled selected>Escolha o semestre</option>
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
			  	<%ArrayList<Aluno> alunos = new ArrayList<>();
			  	alunos = listarAlunos();
			  	if(alunos != null){
					while(!alunos.isEmpty()){ 
				%>
				<tr>
			      <th scope="row" class="text-center"><%out.println(alunos.get(0).getId_aluno()); %></th>
			      <td class="text-center"><%out.println(alunos.get(0).getNome()); %></td>
			      <td><%out.println(alunos.get(0).getRa()); %></td>
			      <td>
				      <form action="ListarAlunos.do" method="get" id="id2<%=alunos.get(0).getId_aluno()%>">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2<%=alunos.get(0).getId_aluno()%>').submit();"></a>
				      		<label><input type="checkbox" value="<%=alunos.get(0).getId_aluno()%>" id="codigoAluno" name="codigoAluno"> <span></span><label>
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>
				<%alunos.remove(0);}
				}else{
				%>
				<tr>
					<th></th>
					<th class="text-center">Nenhuma aluno cadastrado!</th>
				</tr>
				<%} %>
				</tbody>
			</table>
		</div>
		<div class="col-md-6">
			<table class="table table-hover ">
			  <thead>
			    <tr>
			      <th scope="col">Escolha</th>
			      <th scope="col">Turma</th>
			      <th scope="col">Sigla</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  	if(alunos != null){
					while(!alunos.isEmpty()){ 
				%>
				<tr>
			      <th scope="row" class="text-center">
			      	<label>
        				<input name="group1" type="radio" checked />
				        <span></span>
      				</label>
      			  </th>
			      <td class="text-center"><%out.println(alunos.get(0).getNome()); %></td>
			      <td><%out.println(alunos.get(0).getRa()); %></td>
			      <td>

				      <form action="ListarAlunos.do" method="get" id="id2<%=alunos.get(0).getId_aluno()%>">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2<%=alunos.get(0).getId_aluno()%>').submit();">edit</a>
				      		<input type="number" style="display:none;" value="<%=alunos.get(0).getId_aluno()%>" id="codigoAluno" name="codigoAluno">
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>
				<%alunos.remove(0);}
				}else{
				%>
				<tr>
					<th></th>
					<th class="text-center">Nenhuma aluno cadastrado!</th>
				</tr>
				<%} %>
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