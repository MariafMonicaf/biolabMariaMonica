package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.FiloDao;
import br.edu.ifpi.biolab.Entidade.Filo;

public class FiloControle {
	private FiloDao filoDao;

	public FiloControle() {
		filoDao = new FiloDao();
	}

	public void adiciona(Filo filo) throws SQLException {
		filoDao.adicionar(filo);
		filoDao.fechaConexao();
	}

	public void buscaTodos() {

	}

	public void altera(Filo filo) throws SQLException {
		filoDao.altera(filo);
		filoDao.fechaConexao();
	}

	public void deleta(Filo filo) throws SQLException {
		filoDao.deleta(filo);
		filoDao.fechaConexao();
	}

}
