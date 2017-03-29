
package br.edu.ifpi.biolab.Entidade;

public class Classe {
	private int id;
	private String nome;
	private Filo filo;

	public Classe() {
		
	}

	public Classe(String nome, Filo filo) {
		this.nome = nome;
		this.filo = filo;
	}

	public Classe(String string) {
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

	public Filo getFilo() {
		return filo;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}

}
