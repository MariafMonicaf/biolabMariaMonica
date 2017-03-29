package br.edu.ifpi.biolab.Entidade;

public class Genero {
	private int id;
	private String nome;
	private Familia familia;

	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(String nome, Familia familia) {

		this.nome = nome;
		this.familia = familia;
	}

	public Genero(String string) {

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

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}
