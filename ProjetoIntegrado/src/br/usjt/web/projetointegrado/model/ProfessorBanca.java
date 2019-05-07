package br.usjt.web.projetointegrado.model;

public class ProfessorBanca {

	//atributos
	
	private int id_professor_banca;
	private int professor_id;
	private int banca_id;
	private double avaliacao;
	
	//getters and setters

	public int getId_professor_banca() {
		return id_professor_banca;
	}
	public void setId_professor_banca(int id_professor_banca) {
		this.id_professor_banca = id_professor_banca;
	}
	public int getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}
	public int getBanca_id() {
		return banca_id;
	}
	public void setBanca_id(int banca_id) {
		this.banca_id = banca_id;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
}
