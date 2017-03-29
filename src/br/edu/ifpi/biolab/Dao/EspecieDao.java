package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Especie;

public class EspecieDao extends Dao {

	public void adiciona(Especie especie) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = "insert into Especie(nome_vulgar, nome_cientifico,id_genero) Values (?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setInt(3, especie.getGenero().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Especie salva com sucesso");
		con.close();
	}

	public List<Especie> getTodasEspecies() throws SQLException {
		List<Especie> especies = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Especie");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nome vulgar"));
			especie.setNomeCientifico(rs.getString("nome_cientifico"));

			especies.add(especie);

		}
		rs.close();
		stmt.close();
		return especies;

	}

	public void altera(Especie especie) {
		String sql = "update Especie set nomeVulgar=?, nomoCientifico," + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, especie.getNomeVulgar());
			stmt.setString(2, especie.getNomeCientifico());
			stmt.setInt(3, especie.getGenero().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Especie especie) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from especies where id=?");
			stmt.setInt(1, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
