package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Banca;

public class BancaDAO {
	
private Connection conexao;
	
	public BancaDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Banca banca) throws SQLException{
		String sql = "INSERT INTO banca(data, grupo_id, "
				+ "sala) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setDate( 1, (Date) banca.getData());
		ps.setInt(2, banca.getGrupo_id());
		ps.setString(3, banca.getSala());
		
		ps.executeUpdate();
		
	}
	
	public Banca consultar(int id) throws SQLException {
		String sql = "SELECT * FROM banca WHERE id_banca = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Banca banca = new Banca();
			banca.setId_banca(rs.getInt("id_banca"));
			banca.setSala(rs.getString("sala"));
			banca.setData(rs.getDate("data"));
			banca.setGrupo_id(rs.getInt("grupo_id"));
			
			return banca;
		}else {
			return null;
		}
	}
	
	public void alterar(Banca banca) throws SQLException {
		String sql = "UPDATE banca set data = ?, grupo_id = ?,"
				+ "sala = ? where id_banca = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setDate( 1, (Date) banca.getData());
		ps.setInt(2, banca.getGrupo_id());
		ps.setString(3, banca.getSala());
		ps.setInt(4, banca.getId_banca());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM banca WHERE id_banca = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}

}
