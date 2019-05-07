package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.dao.ComentarioDAO;
import br.usjt.web.projetointegrado.model.Comentario;

public class ComentarioService {
	
	ComentarioDAO dao = new ComentarioDAO();
	
	public ArrayList<Comentario> consultar(int id) throws SQLException {
		return dao.consultar(id);
	}
	
	public boolean incluir(Comentario comentario) throws SQLException {
		return dao.incluir(comentario);
	}

}
