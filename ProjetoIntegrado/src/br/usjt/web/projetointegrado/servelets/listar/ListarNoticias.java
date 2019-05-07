package br.usjt.web.projetointegrado.servelets.listar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Noticia;
import br.usjt.web.projetointegrado.service.NoticiaService;

/**
 * Servlet implementation class ListarNoticias
 */
@WebServlet("/ListarNoticias.do")
public class ListarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ide = request.getParameter("codigoNoticia");
		if(!ide.isEmpty()) {
			try {
				int id = Integer.parseInt(ide);
				NoticiaService service = new NoticiaService();
				Noticia noticia = service.consultarUma(id);
				request.setAttribute("UmaNoticia", noticia);
				RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
				rs.forward(request, response); 
			}catch (Exception e) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
				rs.forward(request, response);
			}
		}
		request.setAttribute("erro", "Você esqueceu de preencher algo! :O");
		RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
		rs.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			NoticiaService service = new NoticiaService();
			ArrayList<Noticia> noticias = service.consultar();
			request.getSession().setAttribute("Noticias", noticias);
			
			if(request.getSession().getAttribute("tipoUser").equals("usuario") ||
			request.getSession().getAttribute("tipoUser") == null) {
				RequestDispatcher rs = request.getRequestDispatcher("Index.jsp");
				rs.forward(request, response);
			}else if(request.getSession().getAttribute("tipoUser").equals("admin")) {
				RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
				rs.forward(request, response); 
			}
		}catch (Exception e) {
			if(request.getSession().getAttribute("tipoUser").equals("usuario") ||
			request.getSession().getAttribute("tipoUser") == null) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
				rs.forward(request, response);
			}else if(request.getSession().getAttribute("tipoUser").equals("admin")) {
				request.setAttribute("erro", "Ocorreu um erro inesperado!" + e);
				RequestDispatcher rs = request.getRequestDispatcher("EditarNoticia.jsp");
				rs.forward(request, response);
			}
		}
		doGet(request, response);
	}

}
