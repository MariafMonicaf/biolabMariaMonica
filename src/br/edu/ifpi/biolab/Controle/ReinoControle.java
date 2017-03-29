package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.ReinoDao;
import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoControle {
	private ReinoDao reinoDao;

	public ReinoControle() {
		reinoDao = new ReinoDao();
	}

	public void adiciona(Reino reino) throws SQLException {
		reinoDao.adiciona(reino);
	}

	public List<Reino> buscaTodos() throws SQLException {
		return reinoDao.getTodosReinos();
		

	}

	public void altera(Reino reino) throws SQLException {
		reinoDao.altera(reino);
	}

	public void deleta(Reino reino) throws SQLException {
		reinoDao.deleta(reino);
	}

}
