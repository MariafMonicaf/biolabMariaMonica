package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaDao extends Dao {
	public void adiciona(Familia familia) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = " insert into Ordem(nome, id_ordem) values (?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, familia.getNome());
		stmt.setInt(2, familia.getOrdem().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Familia salva com sucesso");
		con.close();
	}

	public List<Familia> getTodasEspecies() throws SQLException {
		List<Familia> familias = new ArrayList<>();

		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Familia");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Familia familia = new Familia();
			familia.setId(rs.getInt("id"));
			familia.setNome(rs.getString("nome"));

			familias.add(familia);

		}

		rs.close();
		stmt.close();
		return familias;

	}

	public void altera(Familia familia) {
		String sql = "update Familia set nome=?" + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, familia.getNome());
			stmt.setInt(2, familia.getOrdem().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Familia familia) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from familias where id=?");
			stmt.setInt(1, familia.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
