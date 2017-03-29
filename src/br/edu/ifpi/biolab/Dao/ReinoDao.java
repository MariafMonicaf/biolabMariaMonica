package br.edu.ifpi.biolab.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoDao extends Dao {

	public void adiciona(Reino reino) throws SQLException {
		String sql = "insert into Reino (nome) values (?)";

		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.setString(1, reino.getNome());

		stmt.execute();
		stmt.close();
		System.out.println("Reino salvo com sucesso");

	}

	public List<Reino> getTodosReinos() throws SQLException {
		List<Reino> reinos = new ArrayList<>();
		PreparedStatement stmt = getConexao().prepareStatement("select * from Reino");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Reino reino = new Reino();
			reino.setId(rs.getInt("id"));
			reino.setNome(rs.getString("nome"));

			reinos.add(reino);
		}

		rs.close();
		return reinos;

	}

	public void altera(Reino reino) {
		String sql = "update Reino set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, reino.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Reino reino) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from reinos where id=?");
			stmt.setInt(1, reino.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
