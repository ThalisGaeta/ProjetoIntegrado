package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Atividade;
import br.usjt.web.projetointegrado.model.Tema;

public class TemaDAO {

private Connection conexao;
	
	public TemaDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean cadastrar(Tema tema, ArrayList<Atividade> atividades) throws SQLException{
		String sql = "INSERT INTO tema(data_cadastro, introducao, requisitos,"
				+ "titulo) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		ps.setString(1,tema.getData_cadastro());
		ps.setString(2, tema.getIntroducao()); 
		ps.setString(3, tema.getRequisitos());
		ps.setString(4, tema.getTitulo());  
		
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		int id = -1;
		if(rs.next()) {
			id =  rs.getInt(1);
		}
		if(id != -1) {
			AtividadeDAO daoAtividade = new AtividadeDAO();
			Atividade atividade = null;
			while(!atividades.isEmpty()) {
				atividade = null;
				atividade = atividades.get(atividades.size()-1);
				atividade.setTema_id(id);
				daoAtividade.cadastrar(atividade);
				atividades.remove(atividades.size()-1);
			}
			return true;
		}
		return false;
	}
	
	public Tema consultar(int id) throws SQLException {
		String sql = "SELECT * FROM tema WHERE id_tema = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Tema tema = new Tema();
			tema.setIntroducao(rs.getString("introducao"));
			tema.setRequisitos(rs.getString("requisitos"));
			tema.setTitulo(rs.getString("titulo"));
			tema.setData_cadastro(rs.getString("data_cadastro"));
			return tema;
		}else {
			return null;
		}
	}
	
	public void alterar(Tema tema) throws SQLException {
		String sql = "UPDATE tema set  introducao = ?, requisitos = ?, titulo = ? where id_tema = ?" ; 
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, tema.getIntroducao()); 
		ps.setString(2, tema.getRequisitos());
		ps.setString(3, tema.getTitulo());  
		ps.setInt(4, tema.getId_tema());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM tema WHERE id_tema = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}
}
