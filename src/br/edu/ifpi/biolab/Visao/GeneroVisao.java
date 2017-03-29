package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.GeneroControle;
import br.edu.ifpi.biolab.Entidade.Genero;

public class GeneroVisao {
	public GeneroVisao() {
		generoControle = new GeneroControle();
	}

	private GeneroControle generoControle;

	public void adiciona(Genero genero) throws SQLException {
		generoControle.adiciona(genero);
	}

	public void altera(Genero genero) throws SQLException {
		generoControle.altera(genero);
	}

	public void deleta(Genero genero) throws SQLException {
		generoControle.deleta(genero);
	}

	public List<Genero> buscaTodosGeneros() {
		generoControle.buscaTodos();
		return null;
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			GeneroVisao visao = new GeneroVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			opcaoEscolhida = Integer.parseInt(valorD);
			Genero g;
			switch (opcaoEscolhida) {
			case 1:
				List<Genero> generos = visao.buscaTodosGeneros();
				String generosTela = "";
				for (Genero genero : generos) {
					generosTela = generosTela + genero.getId() + " - " + genero.getNome() + "\n";
				}
				JOptionPane.showInputDialog(generosTela);
				break;
			case 2:
				String nomeGenero = JOptionPane.showInputDialog("Informe nome do genero:");
				g = new Genero(nomeGenero);
				visao.adiciona(g);
				break;
			case 3:
				generos = visao.buscaTodosGeneros();
				generosTela = "";
				for (Genero genero : generos) {
					generosTela = generosTela + genero.getId() + " - " + genero.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, generosTela);

				g = new Genero("Genero mm");
				visao.altera(g);
				break;

			case 4:
				generos = visao.buscaTodosGeneros();
				generosTela = "";
				for (Genero genero : generos) {
					generosTela = generosTela + genero.getId() + " - " + genero.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, generosTela);

				g = new Genero("Genero mm");
				visao.deleta(g);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;
			}
		}

	}

}