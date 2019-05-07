package br.usjt.web.projetointegrado.servelets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.usjt.web.projetointegrado.model.Usuario;
import br.usjt.web.projetointegrado.service.UsuarioService;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erro", "Sua solicitação foi invalida, tente novamente! ");
		RequestDispatcher rs = request.getRequestDispatcher("logar.jsp");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = null;
		try {
			UsuarioService usuarioService = new UsuarioService();
			usuario = usuarioService.consultar(email);
		}catch (Exception e) {
			request.setAttribute("erro", "Ops, estamos com um problema no banco de dados, tente novamente!" + e);
			RequestDispatcher rs = request.getRequestDispatcher("logar.jsp");
			rs.forward(request, response);
		}
		
		 if ( usuario != null && usuario.getSenha().equals(senha) ) {
			 if(usuario.getPerfil() == 1 || usuario.getPerfil() == 2 || usuario.getPerfil() == 0) {
				 
				request.getSession().setAttribute("usuario", usuario);
				RequestDispatcher rs = request.getRequestDispatcher("indexAdmin.jsp");
				rs.forward(request, response); 
			 }
		 }else if(usuario == null || !usuario.getSenha().equals(senha)){
			 request.setAttribute("erro", "Usuário e/ou senha inválidos.");
			 RequestDispatcher rs = request.getRequestDispatcher("logar.jsp");
			 rs.forward(request, response);
		 }else {
			 request.setAttribute("erro", "Usuário e/ou senha inválidos.");
			 RequestDispatcher rs = request.getRequestDispatcher("logar.jsp");
			 rs.forward(request, response);
		 }
	}

}
