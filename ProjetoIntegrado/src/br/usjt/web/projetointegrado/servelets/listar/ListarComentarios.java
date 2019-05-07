package br.usjt.web.projetointegrado.servelets.listar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarComentarios
 */
@WebServlet("/ListarComentarios.do")
public class ListarComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarComentarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erro", "Sua solicitação foi invalida, tente novamente! ");
		response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("Index.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getAttribute("codigoNoticia");
		
		
		
		RequestDispatcher rs = request.getRequestDispatcher("Cadastro.jsp");
		rs.forward(request, response);
	}

}
