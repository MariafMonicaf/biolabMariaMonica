package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConexao() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/monicaf_mnanda_BioLab", "aluno", "aluno");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		return null;
	}
}
