package br.edu.ifpi.biolab.Entidade;

public class Familia {

	private int id;
	private String nome;
	private Ordem ordem;
	
	public Familia() {
	}
	
	public Familia(String nome, Ordem ordem) {
		this.nome = nome;
		this.ordem = ordem;
	}

	public Familia(String string) {
		
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

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	
	


}
