package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.GrupoDAO;
import br.usjt.web.projetointegrado.model.Grupo;

public class GrupoService {

	GrupoDAO grupoDAO;
	
	public GrupoService() {
		this.grupoDAO = new GrupoDAO();
	}
	
	public void cadastrar(Grupo grupo) throws SQLException {
			this.grupoDAO.cadastrar(grupo);
	}
	
	public void consultar(int grupo) throws SQLException {
			this.grupoDAO.consultar(grupo);
	}
	
	public void alterar(Grupo grupo) throws SQLException {
			this.grupoDAO.alterar(grupo);
	}
	
	public void deletar(int grupo) throws SQLException {
			this.grupoDAO.deletar(grupo);
	}
}
