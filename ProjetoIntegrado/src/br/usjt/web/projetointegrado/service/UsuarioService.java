package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.AlunoDAO;
import br.usjt.web.projetointegrado.dao.ProfessorDAO;
import br.usjt.web.projetointegrado.dao.UsuarioDAO;
import br.usjt.web.projetointegrado.model.Aluno;
import br.usjt.web.projetointegrado.model.Professor;
import br.usjt.web.projetointegrado.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	ProfessorDAO professorDAO = new ProfessorDAO();
	AlunoDAO alunoDAO = new AlunoDAO();
	
	public Usuario consultar (String email) throws SQLException {
		return dao.consultar(email);
	}
	
	public boolean cadastrarAluno(Aluno aluno) throws SQLException {
		return alunoDAO.cadastrar(aluno);
	}
	
	public boolean cadastrarAdmin(Professor professor)throws SQLException {
		return professorDAO.cadastrarAdministrador(professor);
	}
	
	public boolean cadastrarProfessor(Professor professor)throws SQLException {
		return professorDAO.cadastrarProfessor(professor);
	}
}
