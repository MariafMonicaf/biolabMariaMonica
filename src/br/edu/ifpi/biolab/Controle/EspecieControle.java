package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.EspecieDao;
import br.edu.ifpi.biolab.Entidade.Especie;

public class EspecieControle {
	private EspecieDao especieDao;

	public EspecieControle() {
		especieDao = new EspecieDao();
	}

	public void adiciona(Especie especie) throws SQLException {
		especieDao.adiciona(especie);
		especieDao.fechaConexao();
	}

	public void buscaTodos() {

	}

	public void altera(Especie especie) throws SQLException {
		especieDao.altera(especie);
		especieDao.fechaConexao();
	}

	public void deleta(Especie especie) throws SQLException {
		especieDao.deleta(especie);
		especieDao.fechaConexao();
	}

}
