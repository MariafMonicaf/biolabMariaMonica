package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpi.biolab.Controle.FamiliaContole;
import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaVisao {
	public FamiliaVisao() {
		familiaControle = new FamiliaContole();
	}

	private FamiliaContole familiaControle;

	public void adiciona(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);
	}

	public void altera(Familia familia) throws SQLException {
		familiaControle.altera(familia);
	}

	public void deleta(Familia familia) throws SQLException {
		familiaControle.deleta(familia);
	}

	public List<Familia> buscaTodasFamilias() {
		familiaControle.buscaTodos();
		return null;
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			FamiliaVisao visao = new FamiliaVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			opcaoEscolhida = Integer.parseInt(valorD);
			Familia fa;
			switch (opcaoEscolhida) {
			case 1:
				List<Familia> familias = visao.buscaTodasFamilias();
				String familiasTela = "";
				for (Familia familia : familias) {
					familiasTela = familiasTela + familia.getId() + " - " + familia.getNome() + "\n";
				}
				JOptionPane.showInputDialog(familiasTela);
				break;
			case 2:
				String nomeFamilia = JOptionPane.showInputDialog("Informe nome da familia:");
				fa = new Familia(nomeFamilia);
				visao.adiciona(fa);
				break;
			case 3:
				familias = visao.buscaTodasFamilias();
				familiasTela = "";
				for (Familia familia : familias) {
					familiasTela = familiasTela + familia.getId() + " - " + familia.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, familiasTela);

				fa = new Familia("Familia mm");
				visao.altera(fa);
				break;
			case 4:
				familias = visao.buscaTodasFamilias();
				familiasTela = "";
				for (Familia familia : familias) {
					familiasTela = familiasTela + familia.getId() + " - " + familia.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, familiasTela);

				fa = new Familia("Familia mm");
				visao.deleta(fa);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;
			}
		}
	}

}
