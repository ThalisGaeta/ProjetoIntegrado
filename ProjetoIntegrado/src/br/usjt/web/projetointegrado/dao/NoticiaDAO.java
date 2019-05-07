package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.model.Noticia;

public class NoticiaDAO {
	

	private Connection conexao;
	private PreparedStatement ps = null;
	public NoticiaDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Noticia> consultar () throws SQLException {
		String sql= "SELECT * FROM noticia";
			ArrayList<Noticia> noticias = new ArrayList<Noticia>();
			Noticia noticia;
			ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next() ){
				noticia = new Noticia();
				noticia.setConteudo(resultado.getString("conteudo"));
				noticia.setId(resultado.getInt("id"));
				noticia.setResumo(resultado.getString("resumo"));
				noticia.setTitulo(resultado.getString("titulo"));
				noticias.add(noticia);
			}
			return noticias;
	}
	
	public boolean cadastrarNoticia(Noticia noticia, String email) throws SQLException {
		String sql= "INSERT INTO NOTICIA (conteudo, resumo, titulo, usuario_email) values (?, ?, ?, ?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, noticia.getConteudo());
			ps.setString(2, noticia.getResumo());
			ps.setString(3, noticia.getTitulo());
			ps.setString(4, email);

            ps.executeUpdate();
            return true;
	}
	
	public Noticia consultarUma(int id) throws SQLException {
		Noticia noticia = new Noticia();
		String sql= "SELECT * FROM noticia where id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultado = ps.executeQuery();
			
			while (resultado.next() ){
				noticia.setConteudo(resultado.getString("conteudo"));
				noticia.setId(resultado.getInt("id"));
				noticia.setResumo(resultado.getString("resumo"));
				noticia.setTitulo(resultado.getString("titulo"));
			}
			return noticia;
	}
	
	public boolean excluirNoticia(int id) throws SQLException {
		String sql= "delete from Noticia where id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);

            ps.executeUpdate();
            return true;
		
	}
	
	public boolean atualizar(Noticia noticia) throws SQLException {
		String sql= "UPDATE NOTICIA set conteudo = ?, resumo = ?, titulo = ? where id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, noticia.getConteudo());
			ps.setString(2, noticia.getResumo());
			ps.setString(3, noticia.getTitulo());
			ps.setInt(4, noticia.getId());

            ps.executeUpdate();
            return true;
		
	}

}
