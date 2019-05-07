package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.dao.TemaDAO;
import br.usjt.web.projetointegrado.model.Atividade;
import br.usjt.web.projetointegrado.model.Tema;

public class TemaService {

	TemaDAO temaDAO;
	
	public TemaService() {
		this.temaDAO = new TemaDAO();
	}
	
	public boolean cadastrar(Tema tema, ArrayList<Atividade> atividades) throws SQLException {
			return this.temaDAO.cadastrar(tema, atividades); 
	}
	
	public Tema consultar(int tema) throws SQLException {
			return this.temaDAO.consultar(tema);
	}
	
	public void alterar(Tema tema) throws SQLException {
			this.temaDAO.alterar(tema);
	}
	
	public void deletar(int tema) throws SQLException {
			this.temaDAO.deletar(tema);
	}
}
