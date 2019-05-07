package br.usjt.web.projetointegrado.model;

import java.util.Date;

public class Atividade {
	
	//Atributos
	
	private int id_atividade; 
	private int tema_id;
	private int numero;
	private String descricao;
	private String formatoEntrega;
	private String data_inicio;
	private String data_fim;
	
	//getters and setters
	
	public Atividade() {
		
	}
	
	public Atividade(int numero, String descricao, String formatoEntrega, String dataInicio, String dataFim) {
		this.numero = numero;
		this.descricao = descricao;
		this.formatoEntrega = formatoEntrega;
		this.data_inicio = dataInicio;
		this.data_fim = dataFim;
	}
	public int getId_atividade() {
		return id_atividade;
	}
	public void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}
	public int getTema_id() {
		return tema_id;
	}
	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormatoEntrega() {
		return formatoEntrega;
	}
	public void setFormatoEntrega(String formatoEntrega) {
		this.formatoEntrega = formatoEntrega;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
}
