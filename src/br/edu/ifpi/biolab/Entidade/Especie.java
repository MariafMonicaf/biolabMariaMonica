package br.edu.ifpi.biolab.Entidade;

public class Especie {
	private int id;
	private String nomeVulgar;
	private String nomeCientifico;
	private Genero genero;

	public Especie() {

	}

	public Especie(String nomeVulgar, String nomeCientifico, Genero genero) {
		this.nomeVulgar = nomeVulgar;
		this.nomeCientifico = nomeCientifico;
		this.genero = genero;
	}

	public Especie(String string) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeVulgar() {
		return nomeVulgar;
	}

	public void setNomeVulgar(String nomeVulgar) {
		this.nomeVulgar = nomeVulgar;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
