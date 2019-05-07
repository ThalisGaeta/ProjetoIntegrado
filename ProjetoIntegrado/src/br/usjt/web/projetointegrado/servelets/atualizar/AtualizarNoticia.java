package br.usjt.web.projetointegrado.servelets.atualizar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Noticia;
import br.usjt.web.projetointegrado.service.NoticiaService;

/**
 * Servlet implementation class CadastrarNoticia
 */
@WebServlet("/AtualizarNoticia.do")
public class AtualizarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarNoticia() {
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
		String titulo = request.getParameter("tituloNoticia");
		String resumo = request.getParameter("resumoNoticia");
		String conteudo = request.getParameter("noticia");
		String id = request.getParameter("codigoNoticia");
		
		if(!titulo.isEmpty() && !resumo.isEmpty() && !conteudo.isEmpty()) {
			try {
				Noticia noticia = new Noticia(titulo, resumo, conteudo);
				noticia.setId(Integer.parseInt(id));
				NoticiaService noticiaService = new NoticiaService();
				noticiaService.atualizar(noticia);
				request.setAttribute("erro", "Noticia atualizada com sucesso!");
				request.getSession().setAttribute("UmaNoticia", noticia);
				response.sendRedirect("LerNoticia.do?codigoNoticia=" + noticia.getId());
				
			}catch (Exception e) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				response.sendRedirect("LerNoticia.do?codigoNoticia=" + id);
			}
		}else {
			request.setAttribute("erro", "Você esqueceu de preencher algo! :O");
			response.sendRedirect("LerNoticia.do?codigoNoticia=" + id);
		}
		doGet(request, response);
	}

}
