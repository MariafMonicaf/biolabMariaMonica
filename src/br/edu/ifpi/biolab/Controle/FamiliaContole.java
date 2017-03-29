package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.FamiliaDao;
import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaContole {
	private FamiliaDao familiaDao;

	public void FamiliaControle() {
		familiaDao = new FamiliaDao();
	}

	public void adiciona(Familia familia) throws SQLException {
		familiaDao.adiciona(familia);
		familiaDao.fechaConexao();
	}

	public void buscaTodos() {

	}

	public void altera(Familia familia) throws SQLException {
		familiaDao.altera(familia);
		familiaDao.fechaConexao();
	}

	public void deleta(Familia familia) throws SQLException {
		familiaDao.deleta(familia);
		familiaDao.fechaConexao();
	}

}
