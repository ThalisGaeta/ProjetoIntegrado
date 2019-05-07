package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.AlunoDAO;
import br.usjt.web.projetointegrado.model.Aluno;

public class AlunoService {

	AlunoDAO alunoDAO;
	
	public AlunoService() {
		this.alunoDAO = new AlunoDAO();
	}
	
	public void cadastrar(Aluno aluno) throws SQLException {
			this.alunoDAO.cadastrar(aluno);
	}
	
	public void consultar (int aluno) throws SQLException {
			this.alunoDAO.consultar(aluno);
	}
	
	public void alterar (Aluno aluno) throws SQLException {
			this.alunoDAO.alterar(aluno);
	}
	
	public void deletar (int aluno, int idUsuario) throws SQLException {
			this.alunoDAO.deletar(aluno, idUsuario);
	}
}
