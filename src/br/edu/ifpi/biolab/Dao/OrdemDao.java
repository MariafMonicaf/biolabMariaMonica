package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemDao extends Dao {
	public void adicionar(Ordem ordem) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = " insert into Ordem(nome, id_classe) values (?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, ordem.getNome());
		stmt.setInt(2, ordem.getClasse().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Ordem salva com sucesso");
		con.close();
	}

	public List<Ordem> getTodasEspecies() throws SQLException {
		List<Ordem> ordens = new ArrayList<>();

		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Ordem");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Ordem ordem = new Ordem();
			ordem.setId(rs.getInt("id"));
			ordem.setNome(rs.getString("nome"));

			ordens.add(ordem);

		}

		rs.close();
		stmt.close();
		return ordens;

	}

	public void altera(Ordem ordem) {
		String sql = "update Ordem set nome=?" + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ordem.getNome());
			stmt.setInt(3, ordem.getClasse().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Ordem ordem) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from ordens where id=?");
			stmt.setInt(1, ordem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
