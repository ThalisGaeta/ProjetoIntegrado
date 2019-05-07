package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.model.Usuario;

public class UsuarioDAO {

	private Connection conexao;
	private PreparedStatement ps = null;
	public UsuarioDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario consultar (String email) throws SQLException {
		String sql= "SELECT * FROM usuario WHERE email = ?";
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, email);
		ResultSet resultado = pst.executeQuery();
		if (resultado.next() ){
			Usuario u = new Usuario();
			u.setEmail(resultado.getString("email"));
			u.setNome(resultado.getString("nome"));
			u.setPerfil(resultado.getInt("perfil"));
			u.setSenha(resultado.getString("senha"));
			return u;
		}
		return null;
	}
	
	public int cadastrarAluno(Usuario usuario) throws SQLException {
		String sql= "INSERT INTO USUARIO (email, nome, perfil, senha) values (?, ?, ?, ?)";
		ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, usuario.getEmail());
		ps.setString(2, usuario.getNome());
		ps.setInt(3, 0);
		ps.setString(4, usuario.getSenha());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			int id =  rs.getInt(1);
			return id;
		}
		return -5;
	}
	
	public int cadastrarProfessor(Usuario usuario) throws SQLException {
		String sql= "INSERT INTO USUARIO (email, nome, perfil, senha) values (?, ?, ?, ?)";
		ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, usuario.getEmail());
		ps.setString(2, usuario.getNome());
		ps.setInt(3, 1);
		ps.setString(4, usuario.getSenha());
		ps.execute();
        ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			int id =  rs.getInt(1);
			return id;
		}
		return -5;
	}
	
	public int cadastrarAdmin(Usuario usuario) throws SQLException {
		String sql= "INSERT INTO USUARIO (email, nome, perfil, senha) values (?, ?, ?, ?)";
		ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, usuario.getEmail());
		ps.setString(2, usuario.getNome());
		ps.setInt(3, 2);
		ps.setString(4, usuario.getSenha());
		ps.execute();
	    ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			int id =  rs.getInt(1);
			return id;
		}
		return -5;
	}
	
	public void alterar(Usuario usuario, int id) throws SQLException {
		String sql = "UPDATE usuario set email = ?, nome = ?"
				+ ", senha = ?" 
				+ " where id_usuario = ?" ; 
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setString(1, usuario.getEmail());
		ps.setString(2, usuario.getNome()); 
		ps.setString(3, usuario.getSenha()); 
		ps.executeUpdate();
	}
}
