package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Grupo;

public class GrupoDAO {

private Connection conexao;
	
	public GrupoDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Grupo grupo) throws SQLException{
		String sql = "INSERT INTO grupo(professor_id, numero, nome "
				+ ") VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		

		ps.setInt(1, grupo.getProfessor_id());
		ps.setInt(2, grupo.getNumero()); 
		ps.setString(3, grupo.getNome());
		
		ps.executeUpdate();
		
	}
	
	public Grupo consultar(int id) throws SQLException {
		String sql = "SELECT * FROM grupo WHERE id_grupo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setId_grupo(rs.getInt("id_grupo"));
			grupo.setNumero(rs.getInt("numero"));
			grupo.setNome(rs.getString("nome"));
			grupo.setProfessor_id(rs.getInt("professor_id"));
			
			return grupo;
		}else {
			return null;
		}
	}
	
	public void alterar(Grupo grupo) throws SQLException {
		String sql = "UPDATE grupo set nome = ?, numero = ?, "
				+ "professor_id = ?"
				+ " where id_grupo = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, grupo.getNome());
		ps.setInt( 2, grupo.getNumero()); 
		ps.setInt( 3, grupo.getProfessor_id());
		ps.setInt(4, grupo.getId_grupo());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM grupo WHERE id_grupo = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}
}
