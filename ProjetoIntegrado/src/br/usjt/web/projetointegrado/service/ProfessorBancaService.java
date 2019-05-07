package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ProfessorBancaDAO;
import br.usjt.web.projetointegrado.model.ProfessorBanca;

public class ProfessorBancaService {

	ProfessorBancaDAO professorBancaDAO;
	
	public ProfessorBancaService() {
		this.professorBancaDAO = new ProfessorBancaDAO();
	}
	
	public void cadastrar(ProfessorBanca professorBanca) throws SQLException {
			this.professorBancaDAO.cadastrar(professorBanca);
	}
	
	public void consultar(int professorBanca) throws SQLException {
			this.professorBancaDAO.consultar(professorBanca);
	}
	
	public void alterar(ProfessorBanca professorBanca) throws SQLException {
			this.professorBancaDAO.alterar(professorBanca);
	}
	
	public void deletar(int professorBanca) throws SQLException {
			this.professorBancaDAO.deletar(professorBanca);
	}
}
