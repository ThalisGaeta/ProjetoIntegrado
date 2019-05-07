package br.usjt.web.projetointegrado.servelets.cadastros;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Comentario;
import br.usjt.web.projetointegrado.model.Noticia;
import br.usjt.web.projetointegrado.model.Usuario;
import br.usjt.web.projetointegrado.service.ComentarioService;

/**
 * Servlet implementation class Comentar
 */
@WebServlet("/Comentar.do")
public class Comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comentar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("comentario", "Ops, Não é assim que comenta! :P");
		RequestDispatcher rs = request.getRequestDispatcher("LerNoticia.do");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Noticia noticia = (Noticia) request.getSession().getAttribute("noticia");
		String comentarioEscrito = request.getParameter("comentario");
		if(usuario == null) {
			Integer idNoticia = noticia.getId();
			request.setAttribute("idNoticia", idNoticia);
			request.setAttribute("erro", "Você precisa estar logado para comentar!");
			RequestDispatcher rs = request.getRequestDispatcher("logar.jsp");
			rs.forward(request, response);
		}else {
			if(!comentarioEscrito.isEmpty()) {
				try {
					Comentario comentario = new Comentario();
					ComentarioService service = new ComentarioService();
					service.incluir(comentario);
					request.getSession().setAttribute("UmaNoticia", noticia);
					request.setAttribute("comentario", "Comentario adicionado! ");
					response.sendRedirect("LerNoticia.do?codigoNoticia=" + noticia.getId());
				}catch (Exception e) {
					request.setAttribute("comentario", "Ocorreu um erro inesperado! " + e);
					response.sendRedirect("LerNoticia.do?codigoNoticia=" + noticia.getId());
				}
			}else {
				request.setAttribute("comentario", "Ops, seu comentario não pode ser em branco!");
				response.sendRedirect("LerNoticia.do?codigoNoticia=" + noticia.getId());
			}
		}
	}

}
