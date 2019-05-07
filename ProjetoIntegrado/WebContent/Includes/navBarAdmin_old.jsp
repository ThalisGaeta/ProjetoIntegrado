<nav class="navbar fixed-top mb-auto">
    <a href="#!" class="brand-logo">Projeto Integrado</a>
	<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
	<ul class="nav nav-tabs nav-fill">
		<li class="nav-item" id="home">
	    	<a class="nav-link" href="indexAdmin.jsp" id="homePage">Home</a>
	  	</li>
	  	<li class="nav-item dropdown" id="cadastros"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Cadastrar usuario
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		        <a class="nav-link" href="NovoProfessor.jsp" id="novoAdministradorPage">Novo Professor</a>
		        <a class="nav-link" href="CadastroAluno.jsp" id="novoAdministradorPage">Novo Aluno</a>
	        </div>
      	</li>
      	<li class="nav-item dropdown" id="temas"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Temas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
		        <a class="nav-link" href="NovaNoticia.jsp" id="novoPage">Novo tema</a>
		        <a class="nav-link" href="EditarNoticia.jsp" id="editarPage">Editar um tema</a>
		        <a class="nav-link" href="ListarNoticias.jsp" id="listarTodosPage">Listar todos os temas</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Vincular tema a turma</a>
	        </div>
      	</li>  
      	<li class="nav-item dropdown" id="alunos"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Alunos
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
		        <a class="nav-link" href="#" id="listarTodosPage">Consultar</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Vincular a turma</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Vincular a grupo</a>
	        </div>
      	</li>
      	<li class="nav-item dropdown" id="grupos"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Grupos
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
		        <a class="nav-link" href="#" id="listarTodosPage">Consultar</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Ver notas</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Ver entregas</a>
	        </div>
      	</li>
      	<li class="nav-item dropdown" id="avaliacoes"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Avaliacoes semanais
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
		        <a class="nav-link" href="#" id="listarTodosPage">Consultar</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Cadastrar</a>
	        </div>
      	</li>
      	<li class="nav-item dropdown" id="banca"> 
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	         	Banca
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
		        <a class="nav-link" href="#" id="listarTodosPage">Consultar</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Vincular banca</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Cadastrar declarações</a>
		        <a class="nav-link" href="#" id="listarTodosPage">Gerar declarações</a>
	        </div>
      	</li>	
	  	<li class="nav-item" id="entrega">
	    	<a class="nav-link" href="#">Realizar entrega</a>
	  	</li>	
	  	<li class="nav-item" id="duvidas">
	    	<a class="nav-link" href="#">Duvidas sobre o tema</a>
	  	</li>		
	  	<li class="nav-item">
	    	<a class="nav-link" href="Sair.do">Sair</a>
	  	</li>
	</ul>
	<div class="text-right">Seja bem vindo, <%= usuario.getNome()%></div>
</nav>
 <script>
		$(document).ready(function(){
			var pathname = window.location.pathname;
			console.log(pathname.substring(18, pathname.indexOf('.')));
			if(pathname.substring(18, pathname.indexOf('.')) == "EditarNoticia" || 
					pathname.substring(18, pathname.indexOf('.')) == "NovaNoticia" || 
					pathname.substring(18, pathname.indexOf('.')) == "ListarNoticias"){
				$('#temas').addClass('active');
			};
			if(pathname.substring(18, pathname.indexOf('.')) == "NovoProfessor" ||
					pathname.substring(18, pathname.indexOf('.')) == "CadastroAluno" ){
				$('#cadastros').addClass('active');
			};
			if(pathname.substring(18, pathname.indexOf('.')) == "indexAdmin" ||
					pathname.substring(18, pathname.indexOf('.')) == "Index"||
					pathname.substring(18, pathname.indexOf('.')) == "Login"
					){
				$('#home').addClass('active');
			};
			$('.sidenav').sidenav();
		});
	</script>
	