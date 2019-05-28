package br.usjt.web.projetointegrado.servelets.cadastros;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.projetointegrado.model.Avaliacao;
import br.usjt.web.projetointegrado.model.Professor;
import br.usjt.web.projetointegrado.model.Usuario;
import br.usjt.web.projetointegrado.service.UsuarioService;

/**
 * Servlet implementation class CadastrarAvaliacao
 */
@WebServlet("/CadastrarAvaliacao")
public class CadastrarAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAvaliacao() {
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
		String grupo = request.getParameter("grupo");
		String nota = request.getParameter("nota");
		String comentario = request.getParameter("comentario");
		boolean administrador = request.getParameter("administrador") != null;
		if(!grupo.isEmpty() && !nota.isEmpty() && !comentario.isEmpty()) {
			try {
				Avaliacao avaliacao = new Avaliacao(grupo, nota, comentario);
				UsuarioService service = new UsuarioService();
				if( ra != null ) {
					Aluno aluno = new Aluno(usuario, ra);
					boolean teste = service.cadastrarAluno(aluno);
					if(teste) {
						request.setAttribute("erro", "Novo aluno cadastrado com sucesso! :D");
						RequestDispatcher rs = request.getRequestDispatcher("CadastroAluno.jsp");
						rs.forward(request, response);
					}else {
						request.setAttribute("erro", "Erro ao cadastrar o usuario! ");
						RequestDispatcher rs = request.getRequestDispatcher("CadastroAluno.jsp");
						rs.forward(request, response);
					}
				}else if(matricula != null && administrador) {
					Professor professor = new Professor(usuario, matricula);
					boolean teste = service.cadastrarAdmin(professor);
					if(teste) {
					request.setAttribute("erro", "Novo administrador cadastrado com sucesso! :D");
					RequestDispatcher rs = request.getRequestDispatcher("NovoProfessor.jsp");
					rs.forward(request, response);
					}else {
						request.setAttribute("erro", "Erro ao cadastrar o usuario! ");
						RequestDispatcher rs = request.getRequestDispatcher("NovoProfessor.jsp");
						rs.forward(request, response);						
					}
				}else if(matricula != null && !administrador) {
					Professor professor = new Professor(usuario, matricula);
					boolean teste = service.cadastrarProfessor(professor);
					if(teste) {
					request.setAttribute("erro", "Novo professor cadastrado com sucesso! :D");
					RequestDispatcher rs = request.getRequestDispatcher("NovoProfessor.jsp");
					rs.forward(request, response);
					}else {
						request.setAttribute("erro", "Erro ao cadastrar o usuario! ");
						RequestDispatcher rs = request.getRequestDispatcher("NovoProfessor.jsp");
						rs.forward(request, response);						
					}
				}
			}catch (Exception e) {
				if(matricula != null) {
					request.setAttribute("erro", "Occoreu um erro inesperado no nosso banco de dados! " + e);
					RequestDispatcher rs = request.getRequestDispatcher("NovoProfessor.jsp");
					rs.forward(request, response);
				}else if(ra != null) {
					request.setAttribute("erro", "Occoreu um erro inesperado no nosso banco de dados!" + e);
					RequestDispatcher rs = request.getRequestDispatcher("CadastroAluno.jsp");
					rs.forward(request, response);
				}
			}
		}else {			
			if( request.getSession().getAttribute("tipoUser").equals("usuario")) {
				request.setAttribute("erro", "Você esqueceu de preencher algo! :O");
				RequestDispatcher rs = request.getRequestDispatcher("Cadastro.jsp");
				rs.forward(request, response);
			}else if(request.getSession().getAttribute("tipoUser").equals("admin")) {
				request.setAttribute("erro", "Você esqueceu de preencher algo! :O");
				RequestDispatcher rs = request.getRequestDispatcher("CadastroAluno.jsp");
				rs.forward(request, response);
			}
		}
	}

}
