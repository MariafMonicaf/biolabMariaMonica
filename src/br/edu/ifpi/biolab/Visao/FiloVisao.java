package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpi.biolab.Controle.FiloControle;
import br.edu.ifpi.biolab.Entidade.Filo;

public class FiloVisao {

	public FiloVisao() {
		filoControle = new FiloControle();
	}

	private FiloControle filoControle;

	public void adicionar(Filo filo) throws SQLException {
		filoControle.adiciona(filo);
	}

	public void alterar(Filo filo) throws SQLException {
		filoControle.altera(filo);
	}

	public void deletar(Filo filo) throws SQLException {
		filoControle.deleta(filo);
	}

	public List<Filo> buscaTodosFilos() {
		filoControle.buscaTodos();
		return null;
	}

	public static void main(String[] args) throws SQLException {
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {
			FiloVisao visao = new FiloVisao();
			String menu = "1-\t1-Consultar \n\t2-Adicionar \n\t3-Alterar \n\t4-Deletar \n\t5 Sair";
			JOptionPane.showInputDialog(menu);
			String valorD = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorD);
			opcaoEscolhida = Integer.parseInt(valorD);
			Filo f;
			switch (opcaoEscolhida) {
			case 1:
				List<Filo> filos = visao.buscaTodosFilos();

				String filosTela = "";
				for (Filo filo : filos) {
					filosTela = filosTela + filo.getId() + " - " + filo.getNome() + "\n";
				}
				JOptionPane.showInputDialog(filosTela);
				break;
			case 2:
				String nomeFilo = JOptionPane.showInputDialog("Informe nome do filo:");
				f = new Filo(nomeFilo);
				visao.adicionar(f);
				break;
			case 3:
				filos = visao.buscaTodosFilos();
				filosTela = "";
				for (Filo filo : filos) {
					filosTela = filosTela + filo.getId() + " - " + filo.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, filosTela);

				f = new Filo("Filo mm");
				visao.alterar(f);
				break;
			case 4:
				filos = visao.buscaTodosFilos();
				filosTela = "";
				for (Filo filo : filos) {
					filosTela = filosTela + filo.getId() + " - " + filo.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, filosTela);

				f = new Filo("Filo mm");
				visao.deletar(f);
				break;

			case 5:
				opcaoEscolhida = 0;
				break;
			}
		}

	}

}
