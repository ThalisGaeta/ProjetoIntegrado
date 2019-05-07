package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.AvaliacaoDAO;
import br.usjt.web.projetointegrado.model.Avaliacao;

public class AvaliacaoService {

	AvaliacaoDAO avaliacaoDAO;
	
	public AvaliacaoService() {
		this.avaliacaoDAO = new AvaliacaoDAO();
	}
	
	public void cadastrar(Avaliacao avaliacao) throws SQLException {
			this.avaliacaoDAO.cadastrar(avaliacao);
	}
	
	public void consultar(int avaliacao) throws SQLException {
			this.avaliacaoDAO.consultar(avaliacao);
	}
	
	public void alterar(Avaliacao avaliacao) throws SQLException {
			this.avaliacaoDAO.alterar(avaliacao);
	}
	
	public void deletar(int avaliacao) throws SQLException {
			this.avaliacaoDAO.deletar(avaliacao);
	}
}
