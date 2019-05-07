package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.EntregaDAO;
import br.usjt.web.projetointegrado.model.Entrega;

public class EntregaService {

	EntregaDAO entregaDAO;
	
	public EntregaService() {
		this.entregaDAO = new EntregaDAO();
	}
	
	public void cadastrar(Entrega entrega) throws SQLException {
			this.entregaDAO.cadastrar(entrega);
	}
	
	public void consultar(int entregar) throws SQLException {
			this.entregaDAO.consultar(entregar);
	}
	
	public void alterar(Entrega entrega) throws SQLException {
			this.entregaDAO.alterar(entrega);
	}
	
	public void deletar(int entrega) throws SQLException {
			this.entregaDAO.deletar(entrega);
	}
}
