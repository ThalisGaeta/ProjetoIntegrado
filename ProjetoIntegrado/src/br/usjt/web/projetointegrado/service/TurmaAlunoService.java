package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.TurmaAlunoDAO;
import br.usjt.web.projetointegrado.model.TurmaAluno;

public class TurmaAlunoService {

	TurmaAlunoDAO turmaAlunoDAO;
	
	public TurmaAlunoService() {
		this.turmaAlunoDAO = new TurmaAlunoDAO();
	}
	
	public void cadastrar(TurmaAluno turmaAluno) throws SQLException {
			this.turmaAlunoDAO.cadastrar(turmaAluno);
	}
	
	public void consultar(int turmaAluno) throws SQLException {
			this.turmaAlunoDAO.consultar(turmaAluno);
	}
	
	public void alterar(TurmaAluno turmaAluno) throws SQLException {
			this.turmaAlunoDAO.alterar(turmaAluno);
	}
	
	public void deletar(int turmaAluno) throws SQLException {
			this.turmaAlunoDAO.deletar(turmaAluno);
	}
}
