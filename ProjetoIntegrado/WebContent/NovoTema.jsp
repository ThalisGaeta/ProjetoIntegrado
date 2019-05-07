<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Nova noticia</title>
<body class="fonte">
<%@include file="/Includes/navBarAdmin.jsp" %>
<div class="container mt-5">
	<div class="row justify-content-md-center espaco">
	  	<div class="col-md-6 text-center">
			<h4>Cadastre um novo tema</h4>
		</div>
	</div>
		<%if (request.getAttribute("erro") != null) { %>
		<div class="form-group row justify-content-md-center">
			<div class="col-md-4">
				<div class="collection text-center">
					<a href="#!" class="collection-item"><h5><% out.println(request.getAttribute("erro")); %></h5></a>
				</div>
			</div>
		</div>
		<%} %>
	<div class="row">
		<div class="col">
			<form action="CadastrarNoticia.do"  method="post">
			  	<div class="form-group row justify-content-md-center ">
			  		<div class="col-md-4">
				    	<label for="tituloTema" class="badge badge-info">Titulo do tema </label>
				    	<input type="text" name="tituloTema" class="form-control fonte" id="tituloTema" placeholder="Digite o titulo do tema" maxlength="100" required>
					</div>
			  	</div>
			  	<div class="form-group row justify-content-md-center">
				<div class="col-md-4">
				    <label for="introducaoTema" class="badge badge-info">Introdução do tema</label>
    				<textarea id="introducaoTema" name="introducaoTema" class="materialize-textarea fonte" placeholder="Digite a introdução do tema" maxlength="250" required></textarea>
				</div>
				</div>
				<div class="form-group row justify-content-md-center">
					<div class="col-md-4">
						<label for="requisitoTema" class="badge badge-info">Requisito do tema</label>
    					<textarea id="requisitoTema" name="requisitoTema" class="materialize-textarea fonte" maxlength="1000" placeholder="Digite os requisitos do tema" required></textarea>
    				</div>
				</div>
				<div class="form-group row justify-content-md-center">
					<div class="col-md-4">
						<label class="badge badge-info">Cronograma do tema</label>
    				</div>
				</div>
				<div id="container"></div>
				<div class="row justify-content-md-center text-center">
					<div class="col-md-2 p-1">
						<button type="button" class="btn btn-dark" id="adicionarAtividade">+ atividade</button>
					</div>
					<div class="col-md-2 p-1">
						<button type="submit" class="btn btn-dark" id="finalizar">Postar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	var auxiliarParaNome = -1;
	$('#adicionarAtividade').click(function(){
		if(auxiliarParaNome == -1){
			auxiliarParaNome = 0;
		}
		$("#container").append("<div class=\"form-group row justify-content-md-center\"><div class=\"col-md-4\"><p><label class=\"badge badge-info\">Atividade</label></p><label for=\"descricaoAtividade\" class=\"badge badge-info\">Descricao da atividade</label><textarea id=\"descricaoAtividade\" name=\"descricaoAtividade"+ auxiliarParaNome +"\" class=\"materialize-textarea fonte\" placeholder=\"Digite a descricao da atividade\" maxlength=\"250\" required></textarea></div></div><div class=\"form-group row justify-content-md-center\">	<div class=\"col-md-4\">	    <label for=\"formaDeEntregaAtividade\" class=\"badge badge-info\">Forma de entrega</label>		<textarea id=\"formaDeEntregaAtividade\" name=\"formaDeEntregaAtividade"+ auxiliarParaNome +"\" class=\"materialize-textarea fonte\" placeholder=\"Digite a descricao da atividade\" maxlength=\"250\" required></textarea>	</div></div><div class=\"form-group row justify-content-md-center\">	<div class=\"col-md-2\">	    <label for=\"prazoInicialAtividade\" class=\"badge badge-info\">Prazo inicial</label>			<input type=\"text\" class=\"datepicker\" name=\"prazoInicialAtividade"+ auxiliarParaNome +"\">	</div>	<div class=\"col-md-2\">	    <label for=\"prazoFinalAtividade\" class=\"badge badge-info\">Prazo final</label>			<input type=\"text\" class=\"datepicker\" name=\"prazoFinalAtividade"+ auxiliarParaNome +"\">	</div></div><div id=\"container\"></div>");

		auxiliarParaNome = auxiliarParaNome + 1;
	    $('.datepicker').datepicker();
	    var instance = M.Datepicker.getInstance(elem);
	    instace.disableWeekends(true);
	});
	
	$('#finalizar').click(function(){
		$("#container").append("<input type=\"hidden\" value=\" " + auxiliarParaNome +  " \" name=\"quantidade\">");
	})
	
    $('.datepicker').datepicker();
    var instance = M.Datepicker.getInstance(elem);
    instace.disableWeekends(true);
});
</script>
<%@include file="/Includes/FooterAdmin.jsp" %>
</body>
</html>