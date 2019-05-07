package br.usjt.web.projetointegrado.model;
import java.util.Date;

public class Banca {
	
	//atributos
	
	private int id_banca;
	private int grupo_id;
	private Date data;
	private String sala;
	
	//getters and setters
	
	public int getId_banca() {
		return id_banca;
	}
	public void setId_banca(int id_banca) {
		this.id_banca = id_banca;
	}
	public int getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	

}
