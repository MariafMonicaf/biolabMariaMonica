package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.biolab.Entidade.Genero;

public class GeneroDao extends Dao {
	public void adicionar(Genero genero) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = " insert into Genero(nome, id_familia) values (?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, genero.getNome());
		stmt.setInt(2, genero.getFamilia().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Genero salvo com sucesso, Obrigado pela sua preferencia");
		con.close();
	}

	public List<Genero> getTodasEspecies() throws SQLException {
		List<Genero> generos = new ArrayList<>();

		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Generos");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Genero genero = new Genero();
			genero.setId(rs.getInt("id"));
			genero.setNome(rs.getString("nome"));

			generos.add(genero);

		}

		rs.close();
		stmt.close();
		return generos;
	}

	public void altera(Genero genero) {
		String sql = "update Genero set nome=?," + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.setInt(3, genero.getFamilia().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Genero genero) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from generos where id=?");
			stmt.setInt(1, genero.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
