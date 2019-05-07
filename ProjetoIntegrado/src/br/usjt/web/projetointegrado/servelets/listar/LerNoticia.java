package br.usjt.web.projetointegrado.servelets.listar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Comentario;
import br.usjt.web.projetointegrado.model.Noticia;
import br.usjt.web.projetointegrado.service.ComentarioService;
import br.usjt.web.projetointegrado.service.NoticiaService;

/**
 * Servlet implementation class LerNoticia
 */
@WebServlet("/LerNoticia.do")
public class LerNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int noticiaId = -99;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LerNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide;
		if(noticiaId != -99) {
			ide = "" + noticiaId;
			noticiaId = -99;
		}else {
			ide = request.getParameter("codigoNoticia");
		}
		if(!ide.isEmpty()) {
			try {
				int id = Integer.parseInt(ide);
				NoticiaService service = new NoticiaService();
				Noticia noticia = service.consultarUma(id);
				request.setAttribute("UmaNoticia", noticia);
				ComentarioService serviceComentario = new ComentarioService();
				ArrayList<Comentario> comentarios = new ArrayList<>();
				comentarios = serviceComentario.consultar(id);
				request.setAttribute("comentarios", comentarios);
				RequestDispatcher rs = request.getRequestDispatcher("Noticia.jsp");
				rs.forward(request, response); 
			} catch (Exception e) {
				request.setAttribute("erro", "Não localizamos está noticia... ):" + e);
				RequestDispatcher rs = request.getRequestDispatcher("Noticia.jsp");
				rs.forward(request, response);
			}
			
		}else {
			request.setAttribute("erro", "Não localizamos está noticia... ):");
			RequestDispatcher rs = request.getRequestDispatcher("Noticia.jsp");
			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noticia noticia = (Noticia)request.getSession().getAttribute("UmaNoticia");
		noticiaId = noticia.getId();
		doGet(request, response);
	}

}
