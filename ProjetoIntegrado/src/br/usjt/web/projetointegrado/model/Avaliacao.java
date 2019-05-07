package br.usjt.web.projetointegrado.model;
import java.util.Date;

public class Avaliacao {
	
	//atributos
	
	private int id_avaliacao;
	private int turma_aluno_id;
	private double nota;
	private Date data_avaliacao;
	private String comentarios;
	
	//getters and setters
	
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public int getTurma_aluno_id() {
		return turma_aluno_id;
	}
	public void setTurma_aluno_id(int turma_aluno_id) {
		this.turma_aluno_id = turma_aluno_id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Date getData_avaliacao() {
		return data_avaliacao;
	}
	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
