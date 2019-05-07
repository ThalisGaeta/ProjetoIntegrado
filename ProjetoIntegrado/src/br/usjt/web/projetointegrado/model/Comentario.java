package br.usjt.web.projetointegrado.model;

import java.util.Date;

public class Comentario {
	
	private int id_comentario;
	private int tema_id;
	private int usuario_id;
	private Date data_comentario;
	private String comentario;
	private String nome;
	
	
	public Comentario() {
	}
	
	public Comentario(int tema_id, int usuario_id, String comentario, Date data_comentario) {
		this.tema_id = tema_id;
		this.usuario_id = usuario_id;
		this.comentario = comentario;
		this.data_comentario = data_comentario;
	}
	
	//getters and setters 
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public int getTema_id() {
		return tema_id;
	}

	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Date getData_comentario() {
		return data_comentario;
	}

	public void setData_comentario(Date data_comentario) {
		this.data_comentario = data_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
