<ul id="cadastros" class="dropdown-content">
    <%if(usuario.getPerfil() == 2) {%>
		<li><a class="nav-link" href="NovoProfessor.jsp" id="novoAdministradorPage">Novo Professor</a></li>
	<%} %>
	<li><a class="nav-link" href="CadastroAluno.jsp" id="novoAdministradorPage">Novo Aluno</a></li>
</ul>

<ul id="temas" class="dropdown-content">
	<li><a class="nav-link" href="NovoTema.jsp" id="novoPage">Novo tema</a></li>
	<li><a class="nav-link" href="EditarNoticia.jsp" id="editarPage">Editar um tema</a></li>
	<li><a class="nav-link" href="ListarNoticias.jsp" id="listarTodosPage">Listar todos os temas</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Vincular tema a turma</a></li>
</ul>

<ul id="alunos" class="dropdown-content">
	<li><a class="nav-link" href="ConsultarAlunos.jsp" id="listarTodosPage">Consultar alunos</a></li>
	<li><a class="nav-link" href="VinculoAluno.jsp" id="listarTodosPage">Vincular aluno a turma</a></li>
	<li><a class="nav-link" href="VinculoGrupo.jsp" id="listarTodosPage">Vincular aluno a grupo</a></li>
</ul>

<ul id="grupos" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Ver notas dos grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Ver entregas dos grupos</a></li>
</ul>

<ul id="avaliacoes" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar avaliações semanais</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Cadastrar avaliações semanais</a></li>
</ul>

<ul id="banca" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar bancas</a></li>
	<li><a class="nav-link" href="VinculoBanca.jsp" id="listarTodosPage">Vincular banca a grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Cadastrar declarações</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Gerar declarações</a></li>
</ul>

<ul id="cadastrosMobile" class="dropdown-content">
    <%if(usuario.getPerfil() == 2) {%>
		<li><a class="nav-link" href="NovoProfessor.jsp" id="novoAdministradorPage">Novo Professor</a></li>
	<%} %>
	<li><a class="nav-link" href="CadastroAluno.jsp" id="novoAdministradorPage">Novo Aluno</a></li>
</ul>

<ul id="temasMobile" class="dropdown-content">
	<li><a class="nav-link" href="NovoTema.jsp" id="novoPage">Novo tema</a></li>
	<li><a class="nav-link" href="EditarNoticia.jsp" id="editarPage">Editar um tema</a></li>
	<li><a class="nav-link" href="ListarNoticias.jsp" id="listarTodosPage">Listar todos os temas</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Vincular tema a turma</a></li>
</ul>

<ul id="alunosMobile" class="dropdown-content">
	<li><a class="nav-link" href="ConsultarAlunos.jsp" id="listarTodosPage">Consultar alunos</a></li>
	<li><a class="nav-link" href="VinculoAluno.jsp" id="listarTodosPage">Vincular aluno a turma</a></li>
	<li><a class="nav-link" href="VinculoGrupo.jsp" id="listarTodosPage">Vincular aluno a grupo</a></li>
</ul>/

<ul id="gruposMobile" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Ver notas dos grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Ver entregas dos grupos</a></li>
</ul>

<ul id="avaliacoesMobile" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar avaliações semanais</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Cadastrar avaliações semanais</a></li>
</ul>

<ul id="bancaMobile" class="dropdown-content">
	<li><a class="nav-link" href="#" id="listarTodosPage">Consultar bancas</a></li>
	<li><a class="nav-link" href="VinculoBanca.jsp" id="listarTodosPage">Vincular banca a grupos</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Cadastrar declarações</a></li>
	<li><a class="nav-link" href="#" id="listarTodosPage">Gerar declarações</a></li>
</ul>

<nav class="navbar fixed-top">
	<a href="#" class="brand-logo right"><%= usuario.getNome()%></a>
	<div class="nav-wrapper">
		<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
    		<li><a href="indexAdmin.jsp" id="home">Home page</a></li>
    		<%if(usuario.getPerfil() == 1 || usuario.getPerfil() == 2) {%>
	        	<li><a class="dropdown-trigger" href="#!" data-target="cadastros" id="menuCadastros">Cadastros</a></li>
	        	<li><a class="dropdown-trigger" href="#!" data-target="temas" id="menuTemas">Temas</a></li>
	        	<li><a class="dropdown-trigger" href="#!" data-target="alunos" id="menuAlunos">Alunos</a></li>
	        	<li><a class="dropdown-trigger" href="#!" data-target="grupos" id="menuGrupos">Grupos</a></li>
	        	<li><a class="dropdown-trigger" href="#!" data-target="avaliacoes" id="menuAvaliacoes">Avaliacoes</a></li>
	        	<li><a class="dropdown-trigger" href="#!" data-target="banca" id="menuBanca">Banca</a></li>
	        <%} %>
	        <li><a href="#" id="menuDuvidas">Duvidas sobre o tema</a></li>
        	<%if(usuario.getPerfil() == 0){ %>
        		<li><a href="#" id="menuEntrega">Realizar entrega</a></li>
        	<%} %>
        	<li><a href="Sair.do">Sair</a></li>
      	</ul>
	</div>
</nav>

<ul class="sidenav" id="mobile-demo">
    <li><a href="indexAdmin.jsp" id="homeMobile">Home page</a></li>
    <%if(usuario.getPerfil() == 1 || usuario.getPerfil() == 2) {%>
	  	<li><a class="dropdown-trigger" href="#!" data-target="cadastrosMobile" id="menuCadastrosMobile">Cadastros</a></li>
	   	<li><a class="dropdown-trigger" href="#!" data-target="temasMobile" id="menuTemasMobile">Temas</a></li>
	  	<li><a class="dropdown-trigger" href="#!" data-target="alunosMobile" id="menuAlunosMobile">Alunos</a></li>
	    <li><a class="dropdown-trigger" href="#!" data-target="gruposMobile" id="menuGruposMobile">Grupos</a></li>
	    <li><a class="dropdown-trigger" href="#!" data-target="avaliacoesMobile" id="menuAvaliacoesMobile">Avaliacoes</a></li>
	    <li><a class="dropdown-trigger" href="#!" data-target="bancaMobile" id="menuBancaMobile">Banca</a></li>
    <%} %>
    <li><a href="#" id="menuDuvidasMobile">Duvidas sobre o tema</a></li>
    <%if(usuario.getPerfil() == 0){%>
    	<li><a href="#" id="menuEntregaMobile">Realizar entrega</a></li>
    <%} %>
    <li class="right"><a href="Sair.do">Sair</a></li>
</ul>
<script>
	$(document).ready(function(){
		var pathname = window.location.pathname;
		console.log(pathname.substring(18, pathname.indexOf('.')));
		if(pathname.substring(18, pathname.indexOf('.')) == "EditarNoticia" || 
			pathname.substring(18, pathname.indexOf('.')) == "NovoTema" || 
			pathname.substring(18, pathname.indexOf('.')) == "ListarNoticias"){
			$('#menuTemasMobile').addClass('sublinhar');
			$('#menuTemas').addClass('sublinhar');
		};
		if(pathname.substring(18, pathname.indexOf('.')) == "NovoProfessor" ||
			pathname.substring(18, pathname.indexOf('.')) == "CadastroAluno" ){
			$('#menuCadastrosMobile').addClass('sublinhar');
			$('#menuCadastros').addClass('sublinhar');
		};
		if(pathname.substring(18, pathname.indexOf('.')) == "ConsultarAlunos" ||
			pathname.substring(18, pathname.indexOf('.')) == "VinculoAluno" ||
			pathname.substring(18, pathname.indexOf('.')) == "VinculoGrupo"){
			$('#menuAlunosMobile').addClass('sublinhar');
			$('#menuAlunos').addClass('sublinhar');
			};
		if(pathname.substring(18, pathname.indexOf('.')) == "ConsultarBanca" ||
			pathname.substring(18, pathname.indexOf('.')) == "VinculoBanca" ||
			pathname.substring(18, pathname.indexOf('.')) == "CadastrarDeclarações"){
			$('#menuBancaMobile').addClass('sublinhar');
			$('#menuBanca').addClass('sublinhar');
			};
		if(pathname.substring(18, pathname.indexOf('.')) == "indexAdmin" ||
			pathname.substring(18, pathname.indexOf('.')) == "Index"||
			pathname.substring(18, pathname.indexOf('.')) == "Login"
		){
			$('#home').addClass('sublinhar');
			$('#homeMobile').addClass('sublinhar');
		};
		$('.sidenav').sidenav();
		$('.dropdown-trigger').dropdown();
	});
</script>