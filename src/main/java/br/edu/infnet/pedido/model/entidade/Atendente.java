package br.edu.infnet.pedido.model.entidade;

public class Atendente extends Colaborador {

	private int idade;
	private String formacao;
	private String turno;

	public Atendente() {
	}

	public Atendente(int idade, String formacao, String turno) {
		this.idade = idade;
		this.formacao = formacao;
		this.turno = turno;
	}

	public Atendente(String nome) {
		super();
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Atendente{" +
				"idade=" + idade +
				", formacao='" + formacao + '\'' +
				", turno='" + turno + '\'' +
				'}';
	}
}
