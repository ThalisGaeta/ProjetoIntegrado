package br.usjt.web.projetointegrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.projetointegrado.model.Comentario;

public class ComentarioDAO {
	

	private Connection conexao;
	private PreparedStatement ps = null;
	public ComentarioDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Comentario> consultar (int id) throws SQLException {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Comentario comentario;
		String sql= "SELECT comentario, nome FROM comentario comen"
				+ "inner join usuario us on comen.usuario_id = us.id_usuario"
				+ "inner join tema on comen.tema_id = tema.id_tema"
				+ "WHERE comentario_id = ?";
		ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet resultado = ps.executeQuery();
		while (resultado.next() ){
			comentario = new Comentario();
			comentario.setNome(resultado.getString("nome"));
			comentario.setComentario(resultado.getString("comentario"));
			comentarios.add(comentario);
		}
		return comentarios;
	}
	
	public boolean incluir(Comentario comentario) throws SQLException {
		String sql= "INSERT INTO COMENTARIO (comentario, usuario_id, tema_id) values (?, ?, ?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, comentario.getComentario());
			ps.setInt(2, comentario.getUsuario_id());
			ps.setInt(3, comentario.getTema_id());

            ps.executeUpdate();
            return true;
	}

}
