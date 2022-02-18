package br.senai.sp.sistWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.sistWeb.dao.DaoPessoa;
import br.senai.sp.sistWeb.model.Pessoa;

@Controller
public class PessoaController {

	@RequestMapping("Formpessoa")
	public String mostrarProduto(Pessoa pessoa) {

		return "FormPessoa";
	}

	@RequestMapping("sucesso")
	public String salvarPessoa(Pessoa pessoa) {

		DaoPessoa dao = new DaoPessoa();
		dao.inserir(pessoa);

		System.out.println(pessoa.getNascimento().toString());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getEndereco());
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getTelefone());

		return "redirect:listarPessoa";

	}

	@RequestMapping("listarPessoa")
	public String listaPessoa(Model model) {
		DaoPessoa dao = new DaoPessoa();
		model.addAttribute("pessoa", dao.listar());
		return "sucesso";

	}

	@RequestMapping("excluirPessoa")
	public String excluir(long idPessoa) {
		DaoPessoa dao = new DaoPessoa();
		dao.excluir(idPessoa);
	 return "sucesso";
	}

	@RequestMapping("alterarPessoa")
	public String alterar(long idPessoa, Model model) {
		DaoPessoa dao = new DaoPessoa();
		model.addAttribute("pessoa", dao.listar());

		return "forward: formPessoa";
	}

}
