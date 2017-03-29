package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.OrdemControle;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemVisao {
	public OrdemVisao() {
		ordemControle = new OrdemControle();
	}

	private OrdemControle ordemControle;

	public void adiciona(Ordem ordem) throws SQLException {
		ordemControle.adiciona(ordem);
	}

	public void altera(Ordem ordem) throws SQLException {
		ordemControle.altera(ordem);
	}

	public void deleta(Ordem ordem) throws SQLException {
		ordemControle.deleta(ordem);
	}

	public List<Ordem> buscaTodasOrdens() {
		ordemControle.buscaTodos();
		return null;
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			OrdemVisao visao = new OrdemVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			Ordem o;
			switch (opcaoEscolhida) {
			case 1:
				List<Ordem> ordens = visao.buscaTodasOrdens();
				String ordensTela = "";
				for (Ordem ordem : ordens) {
					ordensTela = ordensTela + ordem.getId() + " - " + ordem.getNome() + "\n";
				}
				JOptionPane.showInputDialog(ordensTela);
				break;
			case 2:
				String nomeOrdem = JOptionPane.showInputDialog("Informe nome da ordem:");
				o = new Ordem(nomeOrdem);
				visao.adiciona(o);
				break;
			case 3:
				ordens = visao.buscaTodasOrdens();
				ordensTela = "";
				for (Ordem ordem : ordens) {
					ordensTela = ordensTela + ordem.getId() + " - " + ordem.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, ordensTela);

				o = new Ordem("Ordem mm");
				visao.altera(o);
				break;
			case 4:
				ordens = visao.buscaTodasOrdens();
				ordensTela = "";
				for (Ordem ordem : ordens) {
					ordensTela = ordensTela + ordem.getId() + " - " + ordem.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, ordensTela);

				o = new Ordem("Ordem mm");
				visao.deleta(o);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;

			}
		}

	}

}