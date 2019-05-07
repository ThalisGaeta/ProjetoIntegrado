package br.usjt.web.projetointegrado.model;

import br.usjt.web.projetointegrado.model.Usuario;

public class Professor extends Usuario{
	
	//atributos
	
	private int id;
	private int usuario_id;
	private String matricula;
	 
	public Professor(){
	}
	
	public Professor(Usuario usuario, String matricula){
		this.matricula = matricula;
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
