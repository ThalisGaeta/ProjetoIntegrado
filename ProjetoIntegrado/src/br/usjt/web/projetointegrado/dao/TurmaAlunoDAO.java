package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.TurmaAluno;

public class TurmaAlunoDAO {

private Connection conexao;
	
	public TurmaAlunoDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(TurmaAluno turmaAluno) throws SQLException{
		String sql = "INSERT INTO turma_aluno(aluno_id, grupo_id,"
				+ "turma_id) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, turmaAluno.getAluno_id());
		ps.setInt( 3, turmaAluno.getGrupo_id()); 
		ps.setInt( 4, turmaAluno.getTurma_id()); 
		
		ps.executeUpdate();
		
	}
	
	public TurmaAluno consultar(int id) throws SQLException {
		String sql = "SELECT * FROM turma_aluno WHERE id_turma_aluno = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			TurmaAluno turmaAluno = new TurmaAluno();
			turmaAluno.setAluno_id(rs.getInt("aluno_id"));
			turmaAluno.setGrupo_id(rs.getInt("grupo_id"));
			turmaAluno.setTurma_id(rs.getInt("turma_id"));
			
			return turmaAluno;
		}else {
			return null;
		}
	}
	
	public void alterar(TurmaAluno turmaAluno) throws SQLException {
		String sql = "UPDATE tema set aluno_id = ?, grupo_id = ?"
				+ ", turmaId = ?" 
				+ " where id_turma_aluno = ?" ; 
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt( 1, turmaAluno.getAluno_id());
		ps.setInt( 2, turmaAluno.getGrupo_id()); 
		ps.setInt( 3, turmaAluno.getTurma_id()); 
		ps.setInt(4, turmaAluno.getId_turma_aluno());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM turmaAluno WHERE id = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}
}
