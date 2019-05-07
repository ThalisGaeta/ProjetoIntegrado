package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.BancaDAO;
import br.usjt.web.projetointegrado.model.Banca;

public class BancaService {

	BancaDAO bancaDAO;
	
	public BancaService() {
		this.bancaDAO = new BancaDAO();
	}
	
	public void cadastrar(Banca banca) throws SQLException {
			this.bancaDAO.cadastrar(banca);
	}
	
	public void consultar(int banca) throws SQLException {
			this.bancaDAO.consultar(banca);
	}
	
	public void alterar(Banca banca) throws SQLException {
			this.bancaDAO.alterar(banca);
	}
	
	public void deletar(int banca) throws SQLException {
			this.bancaDAO.deletar(banca);
	}
}
