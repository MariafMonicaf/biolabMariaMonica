package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.biolab.Entidade.Filo;

public class FiloDao extends Dao {

	public void adicionar(Filo filo) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = "insert into Filo (nome) values (?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, filo.getNome());

		stmt.execute();
		stmt.close();
		System.out.println("Filo salva com sucesso");
		con.close();

	}

	public List<Filo> getTodosFilos() throws SQLException {
		ArrayList<Filo> filos = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement(" select * from Filo");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Filo filo = new Filo();
			filo.setId(rs.getInt("id"));
			filo.setNome(rs.getString("nome"));

			filos.add(filo);

		}

		rs.close();
		stmt.close();
		return null;

	}

	public void altera(Filo filo) {
		String sql = "update Filo set nome=?," + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, filo.getNome());
			stmt.setInt(2, filo.getReino().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Filo filo) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from filos where id=?");
			stmt.setInt(1, filo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
