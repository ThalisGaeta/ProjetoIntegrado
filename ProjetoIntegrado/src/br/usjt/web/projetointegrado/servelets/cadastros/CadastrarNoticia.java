package br.usjt.web.projetointegrado.servelets.cadastros;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Atividade;
import br.usjt.web.projetointegrado.model.Noticia;
import br.usjt.web.projetointegrado.model.Tema;
import br.usjt.web.projetointegrado.model.Usuario;
import br.usjt.web.projetointegrado.service.NoticiaService;
import br.usjt.web.projetointegrado.service.TemaService;

/**
 * Servlet implementation class AtualizarNoticia
 */
@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erro", "Sua solicitação foi invalida, tente novamente! ");
		response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("Cadastro.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("tituloTema");
		String introducao = request.getParameter("introducaoTema");
		String requisito = request.getParameter("requisitoTema");
		String quantidade = request.getParameter("quantidade");
		quantidade = quantidade.substring(1);
		quantidade = quantidade.substring(0, quantidade.length()-1);
		int qtdadeAtividade = Integer.parseInt(quantidade);
		ArrayList<Atividade> atividades = new ArrayList<>();
		Atividade atividade = new Atividade();
		int auxiliar = 0;
		while(auxiliar < qtdadeAtividade) {
			atividade = new Atividade();
			atividade.setDescricao( request.getParameter("descricaoAtividade" + auxiliar));
			atividade.setFormatoEntrega( request.getParameter("formaDeEntregaAtividade" + auxiliar));
			atividade.setData_inicio( request.getParameter("prazoInicialAtividade" + auxiliar));
			atividade.setData_fim( request.getParameter("prazoFinalAtividade" + auxiliar));
			atividades.add(atividade);
			auxiliar++;
		}
		//receber todas as atividades
		if(!titulo.isEmpty() && !introducao.isEmpty() && !requisito.isEmpty()) {
			try {
				String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				Tema tema = new Tema(titulo, introducao, requisito, data);
				TemaService service = new TemaService();
				if(service.cadastrar(tema, atividades)) {
					request.setAttribute("erro", "Noticia cadastrada com sucesso!");
					RequestDispatcher rs = request.getRequestDispatcher("NovoTema.jsp");
					rs.forward(request, response);
				}else {
					request.setAttribute("erro", "Erro ao cadastrar a noticia, tente novamente!");
					RequestDispatcher rs = request.getRequestDispatcher("NovoTema.jsp");
					rs.forward(request, response);
				}
			}catch (Exception e) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				RequestDispatcher rs = request.getRequestDispatcher("NovoTema.jsp");
				rs.forward(request, response);
			}
		}else {
			request.setAttribute("erro", "Você esqueceu de preencher algo! :O");
			RequestDispatcher rs = request.getRequestDispatcher("NovoTema.jsp");
			rs.forward(request, response);
		}
		doGet(request, response);
	}

}
