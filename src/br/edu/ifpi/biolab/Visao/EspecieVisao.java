package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpi.biolab.Controle.EspecieControle;
import br.edu.ifpi.biolab.Entidade.Especie;

public class EspecieVisao {

	public EspecieVisao() {
		especieControle = new EspecieControle();
	}

	private EspecieControle especieControle;

	public void adiciona(Especie especie) throws SQLException {
		especieControle.adiciona(especie);
	}

	public void altera(Especie especie) throws SQLException {
		especieControle.altera(especie);
	}

	public void deleta(Especie especie) throws SQLException {
		especieControle.deleta(especie);
	}

	public List<Especie> buscaTodasEspecies() {
		especieControle.buscaTodos();
		return null;
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			EspecieVisao visao = new EspecieVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			opcaoEscolhida = Integer.parseInt(valorD);
			Especie e;
			switch (opcaoEscolhida) {
			case 1:
				List<Especie> especies = visao.buscaTodasEspecies();
				String especiesTela = "";
				for (Especie especie : especies) {
					especiesTela = especiesTela + especie.getId() + " - " + especie.getNomeVulgar()
							+ especie.getNomeCientifico() + "\n";
				}
				JOptionPane.showInputDialog(especiesTela);
				break;
			case 2:
				String nomeEspecie = JOptionPane.showInputDialog("Informe nome da especie:");
				e = new Especie(nomeEspecie);
				visao.adiciona(e);
				break;
			case 3:
				especies = visao.buscaTodasEspecies();
				especiesTela = "";
				for (Especie especie : especies) {
					especiesTela = especiesTela + especie.getId() + " - " + especie.getNomeVulgar()
							+ especie.getNomeCientifico() + "\n";
				}
				JOptionPane.showMessageDialog(null, especiesTela);

				e = new Especie("Especie mm");
				visao.altera(e);
				break;
			case 4:
				especies = visao.buscaTodasEspecies();
				especiesTela = "";
				for (Especie especie : especies) {
					especiesTela = especiesTela + especie.getId() + " - " + especie.getNomeVulgar()
							+ especie.getNomeCientifico() + "\n";
				}
				JOptionPane.showMessageDialog(null, especiesTela);

				e = new Especie("Especie mm");
				visao.deleta(e);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;
			}

		}

	}

}
