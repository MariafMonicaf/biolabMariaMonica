package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.GeneroDao;
import br.edu.ifpi.biolab.Entidade.Genero;

public class GeneroControle {
	private GeneroDao generoDao;

	public GeneroControle() {
		generoDao = new GeneroDao();
	}

	public void adiciona(Genero genero) throws SQLException {
		generoDao.adicionar(genero);
		generoDao.fechaConexao();
	}

	public void altera(Genero genero) throws SQLException {
		generoDao.altera(genero);
		generoDao.fechaConexao();
	}

	public void deleta(Genero genero) throws SQLException {
		generoDao.deleta(genero);
		generoDao.fechaConexao();
	}

	public void buscaTodos() {

	}
}
