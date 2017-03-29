package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpi.biolab.Controle.ReinoControle;
import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoVisao {

	public ReinoVisao() {
		reinoControle = new ReinoControle();
	}

	private ReinoControle reinoControle;

	public void adiciona(Reino reino) throws SQLException {
		reinoControle.adiciona(reino);
	}

	public void altera(Reino reino) throws SQLException {
		reinoControle.altera(reino);
	}

	public void deleta(Reino reino) throws SQLException {
		reinoControle.deleta(reino);
	}

	public List<Reino> buscaTodosReinos() throws SQLException {
		return reinoControle.buscaTodos();
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			ReinoVisao visao = new ReinoVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			String valorD = JOptionPane.showInputDialog(menu);

			opcaoEscolhida = Integer.parseInt(valorD);
			Reino r;
			List<Reino> reinos;
			String reinosTela = "";
			switch (opcaoEscolhida) {
			case 1:
				reinos = visao.buscaTodosReinos();
				reinosTela = "";
				for (Reino reino : reinos) {
					reinosTela = reinosTela + reino.getId() + " - " + reino.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, reinosTela);
				break;
			case 2:
				String nomeReino = JOptionPane.showInputDialog("Informe nome do reino:");
				r = new Reino(nomeReino);
				visao.adiciona(r);
				break;
			case 3:
				reinos = visao.buscaTodosReinos();
				reinosTela = "";
				for (Reino reino : reinos) {
					reinosTela = reinosTela + reino.getId() + " - " + reino.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, reinosTela);

				r = new Reino("Reino mm");
				visao.altera(r);
				break;
			case 4:
				reinos = visao.buscaTodosReinos();
				reinosTela = "";
				for (Reino reino : reinos) {
					reinosTela = reinosTela + reino.getId() + " - " + reino.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, reinosTela);

				r = new Reino("Reino mm");
				visao.deleta(r);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;
			}
		}

	}

}
