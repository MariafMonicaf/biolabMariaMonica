package br.edu.ifpi.biolab.Dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.ConnectionFactory;

public class ConexcaoTeste {

	public static void main(String[] args) throws SQLException {
		Connection com = (Connection) ConnectionFactory.getConexao();
		System.out.println("Conectado");
		com.close();
	}

}
