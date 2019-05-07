package br.usjt.web.projetointegrado.model;
import java.util.Date;

public class Tema {

	//atributos
	
	private int id_tema;
	private String data_cadastro;
	private String titulo;
	private String introducao;
	private String requisitos;
	
	public Tema() {
		
	}
	public Tema(String titulo, String intoducao, String requisitos, String dataCadastro) {
		this.titulo = titulo;
		this.introducao = intoducao;
		this.requisitos = requisitos;
		this.data_cadastro = dataCadastro;
	}
	//getters and setters
	public int getId_tema() {
		return id_tema;
	}
	public void setId_tema(int id_tema) {
		this.id_tema = id_tema;
	}
	public String getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIntroducao() {
		return introducao;
	}
	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
}
