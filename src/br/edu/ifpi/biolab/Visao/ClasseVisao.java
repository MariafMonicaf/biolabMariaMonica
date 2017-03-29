package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpi.biolab.Controle.ClasseControle;
import br.edu.ifpi.biolab.Entidade.Classe;

public class ClasseVisao {
	public ClasseVisao() {
		classeControle = new ClasseControle();
	}

	private ClasseControle classeControle;

	public void adiciona(Classe classe) throws SQLException {
		classeControle.adiciona(classe);
	}

	public List<Classe> buscaTodasClasses() {
		classeControle.buscaTodosClasse();
		return null;
	}

	public void altera(Classe classe) throws SQLException {
		classeControle.altera(classe);
	}

	public void deleta(Classe classe) throws SQLException {
		classeControle.deleta(classe);
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			ClasseVisao visao = new ClasseVisao();
			String menu = "\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			opcaoEscolhida = Integer.parseInt(valorD);
			Classe c;
			switch (opcaoEscolhida) {
			case 1:
				List<Classe> classes = visao.buscaTodasClasses();
				String classesTela = "";
				for (Classe classe : classes) {
					classesTela = classesTela + classe.getId() + " - " + classe.getNome() + "\n";
				}
				JOptionPane.showInputDialog(classesTela);

				break;
			case 2:
				String nomeClasse = JOptionPane.showInputDialog("Informe nome da classe:");
				c = new Classe(nomeClasse);
				visao.adiciona(c);
				break;
			case 3:
				classes = visao.buscaTodasClasses();
				classesTela = "";
				for (Classe classe : classes) {
					classesTela = classesTela + classe.getId() + " - " + classe.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, classesTela);

				c = new Classe("CClasse mm");
				visao.altera(c);
				break;

			case 4:
				classes = visao.buscaTodasClasses();
				classesTela = "";
				for (Classe classe : classes) {
					classesTela = classesTela + classe.getId() + " - " + classe.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, classesTela);

				c = new Classe("Classe mm");
				visao.deleta(c);
				break;
			case 5:
				opcaoEscolhida = 0;
				break;
			}

		}

	}
}
