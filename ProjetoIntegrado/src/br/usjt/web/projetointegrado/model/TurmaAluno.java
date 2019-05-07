package br.usjt.web.projetointegrado.model;

public class TurmaAluno {
	
	//atributos
	
	private int id_turma_aluno;
	private int aluno_id;
	private int grupo_id;
	private int turma_id;
	
	//getters and setters
	
	public int getId_turma_aluno() {
		return id_turma_aluno;
	}
	public void setId_turma_aluno(int id_turma_aluno) {
		this.id_turma_aluno = id_turma_aluno;
	}
	public int getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(int aluno_id) {
		this.aluno_id = aluno_id;
	}
	public int getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	public int getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(int turma_id) {
		this.turma_id = turma_id;
	}
}
