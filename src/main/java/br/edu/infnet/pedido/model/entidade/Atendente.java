package br.edu.infnet.pedido.model.entidade;

public class Atendente extends Cliente {

	private Long codigo;

	private String nome;

	public Atendente() {
	}

	public Atendente(String nome) {
		super();
		this.nome = nome;
	}

	public Atendente(String nome, Long codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Atendente [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
