package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.dao.UsuarioDAO;
import br.usjt.web.projetointegrado.model.Aluno;
import br.usjt.web.projetointegrado.model.Usuario;

public class AlunoDAO {
	
private Connection conexao;
	
	public AlunoDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean cadastrar(Aluno aluno) throws SQLException{
		String sql = "INSERT INTO aluno(ra, usuario_id) VALUES (?, ?)";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = (Usuario) aluno;
		int usuario_id = usuarioDAO.cadastrarAluno(usuario);
		if(usuario_id == -5) {
			return false;
		}
		aluno.setUsuario_id(usuario_id);
		
		ps.setString(1, aluno.getRa());
		ps.setInt(2, aluno.getUsuario_id());
		ps.executeUpdate();		
		
		return true;		
	}
	
	public Aluno consultar(int id) throws SQLException {
		String sql = "SELECT * FROM aluno a inner join usuario us on a.usuario_id = us.id_usuario  WHERE id_aluno = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setId_aluno(rs.getInt("id_aluno"));
			aluno.setNome(rs.getString("nome"));
			aluno.setEmail(rs.getString("email"));
			aluno.setRa(rs.getString("ra"));
			aluno.setUsuario_id(rs.getInt("usuario_id"));
			return aluno;
		}else {
			return null;
		}
	}
	
	public ArrayList<Aluno> consultarAlunos () throws SQLException {
		String sql= "SELECT * FROM aluno a inner join usuario us on a.usuario_id = us.id_usuario";
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next() ){
				Aluno alunoc = new Aluno();
				alunoc.setId_aluno(rs.getInt("id_aluno"));
				alunoc.setNome(rs.getString("nome"));
				alunoc.setEmail(rs.getString("email"));
				alunoc.setRa(rs.getString("ra"));
				alunoc.setUsuario_id(rs.getInt("usuario_id"));
				alunos.add(alunoc);
			}
			return alunos;
	}
	
	public void alterar(Aluno aluno) throws SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(aluno, aluno.getUsuario_id());
		
		String sql = "UPDATE aluno set  ra = ?"
				+ " where id_aluno = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, aluno.getRa());
		ps.setInt(2, aluno.getUsuario_id());
		
		ps.executeUpdate();
		
	}
	
	public boolean deletar(int idAluno, int idUsuario) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM aluno WHERE id_aluno = ?");
		
		ps.setInt(1, idAluno);
		
		ps.executeUpdate();
		
		ps = this.conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
		
		ps.setInt(1, idUsuario);
		
		ps.executeUpdate();
		
		return true;
		
	}

}
