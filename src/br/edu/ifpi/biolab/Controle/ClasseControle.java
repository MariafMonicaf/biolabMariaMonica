package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.ClasseDao;
import br.edu.ifpi.biolab.Entidade.Classe;

public class ClasseControle {
	private ClasseDao classeDao;

	public ClasseControle() {
		classeDao = new ClasseDao();
	}

	public void adiciona(Classe classe) throws SQLException {
		classeDao.adicionar(classe);
		classeDao.fechaConexao();

	}

	public void altera(Classe classe) throws SQLException {
		classeDao.alterar(classe);
		classeDao.fechaConexao();
	}

	public void deleta(Classe classe) throws SQLException {
		classeDao.deletar(classe);
		classeDao.fechaConexao();
	}

	public void buscaTodosClasse() {

	}
}
