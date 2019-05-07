package br.usjt.web.projetointegrado.model;

public class Noticia {
	
	private String titulo;
	private String resumo;
	private String conteudo;
	private Integer id;
	
	public Noticia() {
	}
	
	public Noticia(String titulo, String resumo, String conteudo) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.conteudo = conteudo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
