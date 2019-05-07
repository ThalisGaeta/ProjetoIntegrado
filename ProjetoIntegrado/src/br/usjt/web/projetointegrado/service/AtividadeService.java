package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.AtividadeDAO;
import br.usjt.web.projetointegrado.model.Atividade;

public class AtividadeService {

	AtividadeDAO atividadeDAO;
	
	public AtividadeService() {
		this.atividadeDAO = new AtividadeDAO();
	}
	
	public void cadastrar(Atividade atividade) throws SQLException {
			this.atividadeDAO.cadastrar(atividade);
	}
	
	public void consultar(int atividade) throws SQLException {
			this.atividadeDAO.consultar(atividade);
	}
	
	public void alterar(Atividade atividade) throws SQLException{
			this.atividadeDAO.alterar(atividade);
	}
	
	public void deletar(int atividade) throws SQLException {
			this.atividadeDAO.deletar(atividade);
	}
}

