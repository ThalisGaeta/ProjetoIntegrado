package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.dao.UsuarioDAO;
import br.usjt.web.projetointegrado.model.Professor;

public class ProfessorDAO {

private Connection conexao;
	
	public ProfessorDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean cadastrarProfessor(Professor professor) throws SQLException{

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		int usuario_id = usuarioDAO.cadastrarAdmin(professor);
		if(usuario_id == -5) {
			return false;
		}
		professor.setUsuario_id(usuario_id);
		
		String sql = "INSERT INTO professor(matricula, "
				+ "usuario_id) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString( 1, professor.getMatricula()); 
		ps.setInt( 2, professor.getUsuario_id());
		
		ps.executeUpdate();	
		return true;
	}
	
	public boolean cadastrarAdministrador(Professor professor) throws SQLException{

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		int usuario_id = usuarioDAO.cadastrarAdmin(professor);
		if(usuario_id == -5) {
			return false;
		}
		professor.setUsuario_id(usuario_id);
		
		
		String sql = "INSERT INTO professor(matricula, "
				+ "usuario_id) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString( 1, professor.getMatricula()); 
		ps.setInt( 2, professor.getUsuario_id());
		
		ps.executeUpdate();	
		return true;
	}
	
	public Professor consultar(int id) throws SQLException {
		String sql = "SELECT * FROM professor WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Professor professor = new Professor();
			professor.setId(rs.getInt("id"));
			professor.setUsuario_id(rs.getInt("usuario_id"));
			professor.setMatricula(rs.getString("matricula"));
			
			return professor;
		}else {
			return null;
		}
	}
	
	public boolean alterar(Professor professor) throws SQLException {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(professor, professor.getUsuario_id());
		
		String sql = "UPDATE professor set"
				+ "matricula = ?"
				+ " where id = ?" ;
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString( 1, professor.getMatricula());
		ps.setInt( 2, professor.getId());
				
		ps.executeUpdate();
		return true;
	}
	
	public boolean deletar(int idProfessor, int idUsuario) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM professor WHERE id = ?");
		
		ps.setInt(1, idProfessor);
		
		ps.executeUpdate();
		
		ps = this.conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
		
		ps.setInt(1, idUsuario);
		
		ps.executeUpdate();
		
		return true;
		
	}
}
