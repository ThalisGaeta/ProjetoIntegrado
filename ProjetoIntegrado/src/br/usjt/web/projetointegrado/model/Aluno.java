package br.usjt.web.projetointegrado.model;

import br.usjt.web.projetointegrado.model.Usuario;

public class Aluno extends Usuario{
	
	//atributos
	
	private int id_aluno;
	private int usuario_id;
	private String ra;
	
	public Aluno(){
		
	}
	
	public Aluno(Usuario usuario, String ra){
		this.ra = ra;
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
	//Getters and Setters

	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(int aluno_id) {
		this.id_aluno = aluno_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
}
