package br.senai.sp.sistWeb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.senai.sp.sistWeb.model.Pessoa;

public class DaoPessoa {

	private Connection conexao;

	public DaoPessoa() {

		conexao = ConectionFactory.conectar();

	}

	// inserindo no BD
	public void inserir(Pessoa pessoa) {

		String sql = "insert into clientes" + "(nome, email, nascimento, endereco, telefone, genero, tipoProduto )"
				+ "values (?,?,?,?,?,?,?)";

		java.sql.PreparedStatement pst;

		try {

			pst = conexao.prepareStatement(sql);

			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getEmail());
			pst.setDate(3, new Date(pessoa.getNascimento().getTimeInMillis()));
			pst.setString(4, pessoa.getEndereco());
			pst.setInt(5, pessoa.getTelefone());
			pst.setString(6, pessoa.getGenero());
			pst.setString(7, pessoa.getTipoProduto());
			pst.execute();


		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

	public List<Pessoa> listar() {
		String sql = "select * from clientes order by nome asc";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		java.sql.PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getLong("id"));

				p.setNome(rs.getString("nome"));

				p.setEmail(rs.getString("email"));

				p.setEndereco(rs.getString("endereco"));

				p.setTelefone(rs.getInt("telefone"));

				p.setGenero(rs.getString("genero"));

				p.setTipoProduto(rs.getString("tipoProduto"));

				// cria um Calendar
				Calendar validade = Calendar.getInstance();

				Date dataBd = rs.getDate("nascimento");

				// "setar" a data do Calendar pela data do Date
				validade.setTimeInMillis(dataBd.getTime());

				lista.add(p);

			}

			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public void excluir(long id) {
		String sql = "delete from clientes where id = ?";
		java.sql.PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setLong(1, id);
			pst.execute();
			pst.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Pessoa pessoa) {
		String sql = "update clientes set nome = ?, nascimento = ?, endereco = ?, email = ? , genero = ?, telefone = ?, tipoProduto = ? where id= ?";
		java.sql.PreparedStatement pst;
		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setDate(2, new Date(pessoa.getNascimento().getTimeInMillis()));
			pst.setString(3, pessoa.getEndereco());
			pst.setString(4, pessoa.getEmail());
			pst.setString(5, pessoa.getGenero());
			pst.setInt(6, pessoa.getTelefone());
			pst.setString(7, pessoa.getTipoProduto());
			pst.setLong(8, pessoa.getId());
			pst.execute();
			pst.close();
			conexao.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
