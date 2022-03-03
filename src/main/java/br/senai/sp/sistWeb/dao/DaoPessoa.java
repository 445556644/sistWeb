package br.senai.sp.sistWeb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

		String sql = "insert into clientes" + "(nome, email, nascimento, endereco, telefone, genero, tipoProduto, dataRegistro )"
				+ "values (?,?,?,?,?,?,?,?)";

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
			Calendar gc = Calendar.getInstance();
			pessoa.setDataRegistro(gc);
			pst.setTimestamp(8, new Timestamp(pessoa.getDataRegistro().getTimeInMillis()));
			pst.execute();
			pst.close();
			conexao.close();

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
				Calendar dtNascimento = Calendar.getInstance();

				Date dataBd = rs.getDate("nascimento");

				// "setar" a data do Calendar pela data do Date
				dtNascimento.setTimeInMillis(dataBd.getTime());
				
				p.setNascimento(dtNascimento);
				
				Calendar dataReg = Calendar.getInstance();
				Timestamp timestp = rs.getTimestamp("dataRegistro");
				dataReg.setTimeInMillis(timestp.getTime());
				p.setDataRegistro(dataReg);

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

	public int qtdFem() {
		//genero apelida o resultado genero(do banco de dados)
		String sql = "select count(genero) genero from clientes where genero = 'f'";
		PreparedStatement pst;
		try {
			
			int qtd = 0;
			
			pst = conexao.prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				qtd = rs.getInt(1);
				
			}			
			pst.execute();
			pst.close();			
			return qtd;
						
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int qtdMasc() {
		//genero apelida o resultado genero(do banco de dados)
		String sql = "select count(genero) genero from clientes where genero = 'm'";
		PreparedStatement pst;
		try {			
			
			int qtd = 0;
			
			pst = conexao.prepareStatement(sql);
						
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				qtd = rs.getInt(1);
				
			}			
			pst.execute();
			pst.close();			
			return qtd;
						
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public Pessoa buscar(long idPessoa) {

		String sql = "select *from clientes where id = ?";

		Pessoa p = null;

		PreparedStatement pst;

		try {
			// apos conectar ira realizar o comando da variavel sql
			pst = conexao.prepareStatement(sql);

			pst.setLong(1, idPessoa);
			ResultSet rs = pst.executeQuery();

			// "ira fazer enquanto existir uma tabela"
			if (rs.next()) {

				p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setTipoProduto(rs.getString("tipoProduto"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				p.setGenero(rs.getString("genero"));
				p.setTelefone(rs.getInt("telefone"));

				// criando um calendar
				Calendar dtNascimento = Calendar.getInstance();
	
				// tirando a data do resultSet
				Date dataBd = rs.getDate("nascimento");

				// setar a data do calendar pela data do date
				dtNascimento.setTimeInMillis(dataBd.getTime());

				// setar a data da pessoa
				p.setNascimento(dtNascimento);
				
				Calendar ca = Calendar.getInstance();
				Date ts = rs.getDate("dataRegistro");
				ca.setTimeInMillis(ts.getTime());
				p.setDataRegistro(ca);
				
				
			}

			// fechando tudo
			rs.close();
			pst.close();
			conexao.close();						
			return p;

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
