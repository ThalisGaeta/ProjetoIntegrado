package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Avaliacao;

public class AvaliacaoDAO {
	
private Connection conexao;
	
	public AvaliacaoDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Avaliacao avaliacao) throws SQLException{
		String sql = "INSERT INTO avaliacao(comentarios, data_avaliacao, "
				+ "nota, turma_aluno_id) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, avaliacao.getComentarios());
		ps.setDate( 2, (Date) avaliacao.getData_avaliacao());
		ps.setDouble(3, avaliacao.getNota());
		ps.setInt(4, avaliacao.getTurma_aluno_id());
		
		ps.executeUpdate();
		
	}
	
	public Avaliacao consultar(int id) throws SQLException {
		String sql = "SELECT * FROM avaliacao WHERE id_avaliacao = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setId_avaliacao(rs.getInt("id_avaliacao"));
			avaliacao.setComentarios(rs.getString("comentarios"));
			avaliacao.setData_avaliacao(rs.getDate("data_avaliacao"));
			avaliacao.setNota(rs.getInt("nota"));
			avaliacao.setTurma_aluno_id(rs.getInt("turma_aluno_id"));
			
			
			return avaliacao;
		}else {
			return null;
		}
	}
	
	public void alterar(Avaliacao avaliacao) throws SQLException {
		String sql = "UPDATE avaliacao set comentarios = ?, data_avaliacao = ?,"
				+ "nota = ?, turma_aluno_id = ? where id_avaliacao = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, avaliacao.getComentarios());
		ps.setDate( 2, (Date) avaliacao.getData_avaliacao());
		ps.setDouble(3, avaliacao.getNota());
		ps.setInt(4, avaliacao.getTurma_aluno_id());
		ps.setInt(5, avaliacao.getId_avaliacao());
				
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM avaliacao WHERE id_avaliacao = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}

}
