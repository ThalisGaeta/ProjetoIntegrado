package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ProfessorDAO;
import br.usjt.web.projetointegrado.model.Professor;

public class ProfessorService {

	ProfessorDAO professorDAO;
	
	public ProfessorService() {
		this.professorDAO = new ProfessorDAO();
	}
	
	public void cadastrarProfessor(Professor professor) throws SQLException {
			this.professorDAO.cadastrarProfessor(professor);
	}
	
	public void cadastrarAdministrador(Professor professor) throws SQLException {
			this.professorDAO.cadastrarProfessor(professor);
	}
	
	public void consultar(int professor) throws SQLException {
			this.professorDAO.consultar(professor);
	}
	
	public void alterar(Professor professor) throws SQLException {
			this.professorDAO.alterar(professor);
	}
	
	public void deletar(int idProfessor, int idUsuario) throws SQLException {
			this.professorDAO.deletar(idProfessor, idUsuario);
	}
}
