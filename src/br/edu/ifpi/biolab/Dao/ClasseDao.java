package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Classe;

public class ClasseDao extends Dao {
	public void adicionar(Classe classe) throws SQLException {
		Connection con = ConnectionFactory.getConexao();
		String sql = " insert into Classe(nome, id_filo) values (?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, classe.getNome());
		stmt.setInt(2, classe.getFilo().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Classe salva com sucesso");
		con.close();
	}

	public List<Classe> getTodasEspecies() throws SQLException {
		List<Classe> classes = new ArrayList<>();

		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Classe");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Classe classe = new Classe();
			classe.setId(rs.getInt("id"));
			classe.setNome(rs.getString("nome"));

			classes.add(classe);

		}

		rs.close();
		stmt.close();

		return classes;

	}

	public void alterar(Classe classe) {
		String sql = "update Classe set nome=?" + "where id=?";
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setInt(2, classe.getFilo().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Classe classe) {
		try {
			Connection con = ConnectionFactory.getConexao();
			PreparedStatement stmt = con.prepareStatement("delete" + "from classes where id=?");
			stmt.setInt(1, classe.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
