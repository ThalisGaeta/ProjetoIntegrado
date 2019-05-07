package br.usjt.web.projetointegrado.servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.service.NoticiaService;

/**
 * Servlet implementation class ExcluirNoticia
 */
@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirNoticia() {
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
		String ide = request.getParameter("codigoNoticia");
		if(!ide.isEmpty()) {
			try {
				int id = Integer.parseInt(ide);
				NoticiaService service  = new NoticiaService();
				service.excluirNoticia(id);
				request.setAttribute("excluirNoticia", "Noticia excluida! Não da mais pra voltar atras :O");
				RequestDispatcher rs = request.getRequestDispatcher("ListarNoticias.jsp");
				rs.forward(request, response); 
			}catch (Exception e) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				RequestDispatcher rs = request.getRequestDispatcher("ListarNoticias.jsp");
				rs.forward(request, response);
			}
		}else {
			request.setAttribute("erro", "Sair apagando HTML alheio não é legal ):");
			RequestDispatcher rs = request.getRequestDispatcher("ListarNoticias.jsp");
			rs.forward(request, response); 
		}
	}

}
