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
		<div><select>
			<option>1</option>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col">
			
			<table class="table table-hover ">
			  <thead>
			    <tr>
			      <th scope="col">Matricula</th>
			      <th scope="col">Nome</th>

			      <th scope="col">Editar</th>
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
				      		<a href="#!" class="material-icons corA" onClick="document.getElementById('id2<%=alunos.get(0).getId_aluno()%>').submit();">edit</a>
				      		<input type="number" style="display:none;" value="<%=alunos.get(0).getId_aluno()%>" id="codigoAluno" name="codigoAluno">
				      		<button type="submit" id="editarNoticia" style="display:none;"></button>
				      </form> 
			      </td>
			    </tr>
				<%	}
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
</div>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>