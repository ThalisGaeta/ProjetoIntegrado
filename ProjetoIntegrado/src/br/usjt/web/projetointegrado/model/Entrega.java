package br.usjt.web.projetointegrado.model;
import java.util.Date;

public class Entrega {
	
	//atributos
	
	private int id_entrega;
	private int grupo_id;
	private int atividades_id;
	private Date data_cadastro;
	
	//getters and setters
	
	public int getId_entrega() {
		return id_entrega;
	}
	public void setId_entrega(int id_entrega) {
		this.id_entrega = id_entrega;
	}
	public int getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	public int getAvaliacoes_id() {
		return atividades_id;
	}
	public void setAvaliacoes_id(int atividades_id) {
		this.atividades_id = atividades_id;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
}
