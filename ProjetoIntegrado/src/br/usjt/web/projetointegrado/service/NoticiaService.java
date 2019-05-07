package br.usjt.web.projetointegrado.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.dao.NoticiaDAO;
import br.usjt.web.projetointegrado.model.Noticia;

public class NoticiaService {
	
	NoticiaDAO dao = new NoticiaDAO();
	
	public ArrayList<Noticia> consultar() throws SQLException{
		return dao.consultar();
	}
	
	public boolean cadastrarNoticia(Noticia noticia, String email)throws SQLException{
		return dao.cadastrarNoticia(noticia, email);
	}
	
	public Noticia consultarUma(int id) throws SQLException{
		return dao.consultarUma(id);
	}
	
	public boolean excluirNoticia(int id) throws SQLException{
		return dao.excluirNoticia(id);
	}
	
	public boolean atualizar(Noticia noticia) throws SQLException{
		return dao.atualizar(noticia);
	}
	

}
