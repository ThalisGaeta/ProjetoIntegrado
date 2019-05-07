package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.ProfessorBanca;

public class ProfessorBancaDAO {

private Connection conexao;
	
	public ProfessorBancaDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(ProfessorBanca professorBanca) throws SQLException{
		String sql = "INSERT INTO professorBanca(banca_id, avaliacao, "
				+ "professor_id) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, professorBanca.getBanca_id());
		ps.setDouble(2, professorBanca.getAvaliacao());
		ps.setInt( 3, professorBanca.getProfessor_id()); 
		
		ps.executeUpdate();
		
	}
	
	public ProfessorBanca consultar(int id) throws SQLException {
		String sql = "SELECT * FROM professorBanca WHERE id_professor_banca = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			ProfessorBanca professorBanca = new ProfessorBanca();
			professorBanca.setId_professor_banca(rs.getInt("id_professor_banca"));
			professorBanca.setBanca_id(rs.getInt("banca_id"));
			professorBanca.setAvaliacao(rs.getDouble("nota"));
			professorBanca.setProfessor_id(rs.getInt("professor_id"));
			
			return professorBanca;
		}else {
			return null;
		}
	}
	
	public void alterar(ProfessorBanca professorBanca) throws SQLException {
		String sql = "UPDATE professorBanca set banca_id = ?, avaliacao = ?, professor_id = ?"
				+ " where id_professor_banca = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, professorBanca.getBanca_id());
		ps.setDouble(2, professorBanca.getAvaliacao());
		ps.setInt( 3, professorBanca.getProfessor_id());
		ps.setInt(4, professorBanca.getId_professor_banca());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM professorBanca WHERE id_professor_banca = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}
}
