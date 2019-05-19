<%@page import="br.usjt.web.projetointegrado.dao.BancaDAO"%>
<%@page import="br.usjt.web.projetointegrado.model.Banca"%>
<%@page import="java.util.ArrayList"%>
<%!public ArrayList<Banca> listarAlunos(){
	BancaDAO dao = new BancaDAO();
	ArrayList<Banca> banca = null;
	try{
		banca = dao.consultar(id);
		return banca;
	}catch(Exception e){
		return null;
	}
}%>
<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Listar Banca</title>
</head>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Vincular Bancas aos grupos</h4>
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

			      <th scope="col">Editar</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%ArrayList<Banca> banca = new ArrayList<>();
			  	banca = listarBanca();
			  	if(banca != null){
					while(!banca.isEmpty()){ 
				%>
				<tr>
			      <th scope="row" class="text-center"><%out.println(banca.get(0).getId_banca()); %></th>
			      <td class="text-center"><%out.println(banca.get(0).getNome()); %></td>
			      <td><%out.println(banca.get(0).getRa()); %></td>
			      <td>
				      <form action="ListarAlunos.do" method="get" id="id2<%=banca.get(0).getId_banca()%>">
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2<%=banca.get(0).getId_banca()%>').submit();"></a>
				      		<label><input type="checkbox" value="<%=banca.get(0).getId_banca()%>" id="codigoAluno" name="codigoAluno"> <span></span><label>
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>
				<%banca.remove(0);}
				}else{
				%>
				<tr>
					<th></th>
					<th class="text-center">Nenhuma banca cadastrada!</th>
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