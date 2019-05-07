package br.usjt.web.projetointegrado.model;

public class Usuario {

	
	protected String email;
	protected String nome;
	protected	String senha;
	protected int perfil;
	protected int id_usuario;
		
	public Usuario(){
	}
	
	public Usuario(String email, String nome, String senha){
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
}
