package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Entrega;

public class EntregaDAO {
	
private Connection conexao;
	
	public EntregaDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Entrega entrega) throws SQLException{
		String sql = "INSERT INTO entrega(avaliacoes_id, data_cadastro, "
				+ "grupo_id, sala) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, entrega.getAvaliacoes_id());
		ps.setDate(2, (Date) entrega.getData_cadastro());
		ps.setInt( 3, entrega.getGrupo_id()); 
		
		ps.executeUpdate();
		
	}
	
	public Entrega consultar(int id) throws SQLException {
		String sql = "SELECT * FROM entrega WHERE id_entrega = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Entrega entrega = new Entrega();
			entrega.setId_entrega(rs.getInt("id_entrega"));
			entrega.setData_cadastro(rs.getDate("data_cadastro"));
			entrega.setAvaliacoes_id(rs.getInt("avaliacoes_id"));
			entrega.setGrupo_id(rs.getInt("grupo_id"));
			
			return entrega;
		}else {
			return null;
		}
	}
	
	public void alterar(Entrega entrega) throws SQLException {
		String sql = "UPDATE entrega set avaliacoes_id = ?, grupo_id = ?, data_cadastro = ?"
				+ " where id_entrega = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, entrega.getAvaliacoes_id());
		ps.setInt( 2, entrega.getGrupo_id()); 
		ps.setDate(3, (Date) entrega.getData_cadastro());
		ps.setInt(4, entrega.getId_entrega());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM entrega WHERE id_entrega = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}

}
