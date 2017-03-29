package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.OrdemDao;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemControle {
	private OrdemDao OrdemDao;

	public OrdemControle() {
		OrdemDao = new OrdemDao();
	}

	public void adiciona(Ordem ordem) throws SQLException {
		OrdemDao.adicionar(ordem);
		OrdemDao.fechaConexao();
	}

	public void buscaTodos() {

	}

	public void altera(Ordem ordem) throws SQLException {
		OrdemDao.altera(ordem);
		OrdemDao.fechaConexao();
	}

	public void deleta(Ordem ordem) throws SQLException {
		OrdemDao.deleta(ordem);
		OrdemDao.fechaConexao();
	}

}
