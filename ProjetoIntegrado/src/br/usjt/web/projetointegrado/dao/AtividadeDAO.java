package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.projetointegrado.dao.ConnectionFactory;
import br.usjt.web.projetointegrado.model.Atividade;


public class AtividadeDAO {

private Connection conexao;
	
	public AtividadeDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void cadastrar(Atividade atividade) throws SQLException{
		String sql = "INSERT INTO atividade(descricao, data_fim,"
				+ " data_inicio, formato_entrega, numero, tema_id ) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, atividade.getDescricao());
		ps.setString( 2, atividade.getData_fim());
		ps.setString( 3, atividade.getData_inicio()); 
		ps.setString( 4, atividade.getFormatoEntrega());
		ps.setInt(5, atividade.getNumero());
		ps.setInt(6, atividade.getTema_id());
		
		ps.executeUpdate();
		
	}
	
	public Atividade consultar(int id) throws SQLException {
		String sql = "SELECT * FROM atividade WHERE id_atividade = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Atividade atividade = new Atividade();
			atividade.setId_atividade(rs.getInt("id_atividade"));
			atividade.setDescricao(rs.getString("descricao"));
			atividade.setData_fim(rs.getString("data_fim"));
			atividade.setData_inicio(rs.getString("data_inicio"));
			atividade.setFormatoEntrega(rs.getString("formato_entrega"));
			atividade.setNumero(rs.getInt("numero"));
			atividade.setTema_id(rs.getInt("tema_idd"));
			
			
			return atividade;
		}else {
			return null;
		}
	}
	
	public void alterar(Atividade atividade) throws SQLException {
		String sql = "UPDATE atividade set descricao = ?, data_fim = ?, data_inicio = ?"
				+ "formato_entrega = ? numero = ? temaId = ? where id = ?" ;
		
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		
		ps.setString(1, atividade.getDescricao());
		ps.setString( 2, atividade.getData_fim());
		ps.setString( 3, atividade.getData_inicio()); 
		ps.setString(4, atividade.getFormatoEntrega());
		ps.setInt(5, atividade.getNumero());
		ps.setInt(6, atividade.getTema_id());
		ps.setInt(7, atividade.getId_atividade());
		
		ps.executeUpdate();
		
	}
	
	public void deletar(int id) throws SQLException {
		
		PreparedStatement ps = this.conexao.prepareStatement("DELETE FROM atividade WHERE id = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	}
}
