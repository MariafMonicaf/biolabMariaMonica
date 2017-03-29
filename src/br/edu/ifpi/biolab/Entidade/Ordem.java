package br.edu.ifpi.biolab.Entidade;

public class Ordem {
	private int id;
	private String nome;
	private Classe classe;

	public Ordem() {
	}

	public Ordem(String nome, Classe classe) {
		this.nome = nome;
		this.classe = classe;
	}

	public Ordem(String string) {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
