package br.senai.sp.sistWeb.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Pessoa {

	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar nascimento;
	private String nome;
	private String tipoProduto;
	private String endereco;
	private String email;
	private int telefone;
	private String m;
	private String f;
	private String prefiro;
	private String genero;

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getPrefiro() {
		return prefiro;
	}

	public void setPrefiro(String prefiro) {
		this.prefiro = prefiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
