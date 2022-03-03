package br.senai.sp.sistWeb.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
		model.addAttribute("generoFem", dao.qtdFem());
		model.addAttribute("generoMasc", dao.qtdMasc());
		int domingo = 0, segunda = 0, terca = 0, quarta = 0,quinta = 0,sexta = 0,sabado = 0;
		int anoAtual = Calendar.getInstance().YEAR;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
		
		int jovem = 0, adulto = 0, idoso = 0;
		List<Pessoa> pessoas = dao.listar();
		
		for (Pessoa p : pessoas) {

			String faixaetaria = fmt.format(p.getNascimento().getTime());
			int faixaInt = Integer.parseInt(faixaetaria);

			if (faixaInt >= 2010) {
				jovem++;
			} else if (faixaInt >= 1950) {
				adulto++;
			} else {
				idoso++;
			}
			int dia = Calendar.getInstance().DAY_OF_WEEK;
		
			SimpleDateFormat fmt2 = new SimpleDateFormat("dd");
			String dataRegis = fmt2.format(p.getDataRegistro().getTime()); 
			int registroInt = Integer.parseInt(dataRegis);
			/*if (registroInt == 1) {
				
				segunda++;
				} else if (registroInt == 2) {
				
				terca++;
				} else if (registroInt == 3) {
				
				quarta++;
				} else if (registroInt == 4) {
				
					quinta++;
				} else if (registroInt == 5) {
				
				sexta++;
				} else if (registroInt == 6) {
			
				sabado++;
				} else if (registroInt == 0) {
				domingo++;
				}*/
			
			switch (p.getDataRegistro().get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				domingo++;
				break;
			case Calendar.MONDAY:
				segunda++;
				break;
				
			case Calendar.TUESDAY:
				terca++;
				break;
				
			case Calendar.WEDNESDAY:
			quarta++;
				break;
				
			case Calendar.THURSDAY:
				quinta++;
				break;
				
			case Calendar.FRIDAY:
				sexta++;
				break;
			case Calendar.SATURDAY:
				sabado++;
				break;
			default:
				break;
			}

		}
		
		int periodoDia = 0, periodoTarde = 0, periodoNoite = 0;
		for (Pessoa p3 : pessoas) {

			SimpleDateFormat formatador = new SimpleDateFormat("HH");
			String horaRegis = formatador.format(p3.getDataRegistro().getTime()); 
			int registroInt = Integer.parseInt(horaRegis);			
			if (registroInt <= 12) {
				
				periodoDia ++;
				
			}else if (registroInt <= 18) {
		
				periodoTarde++;
				
			}else {
				periodoNoite ++;
			}					
		}
		Pessoa pe = new Pessoa();
		model.addAttribute("pessoa", pessoas);
		model.addAttribute("jovem", jovem);
		model.addAttribute("adulto", adulto);
		model.addAttribute("idoso", idoso);
		model.addAttribute("dia", periodoDia);
		model.addAttribute("tarde", periodoTarde);
		model.addAttribute("noite", periodoNoite);
		model.addAttribute("segunda", segunda);
		model.addAttribute("terca", terca);
		model.addAttribute("quarta", quarta);
		model.addAttribute("quinta", quinta);
		model.addAttribute("sexta", sexta);
		model.addAttribute("sabado", sabado);
		model.addAttribute("domingo", domingo);
		return "sucesso";
		
		
	}

	@RequestMapping("excluirPessoa")
	public String excluir(long idPessoa) {
		DaoPessoa dao = new DaoPessoa();
		dao.excluir(idPessoa);
		return "redirect:listarPessoa";
	}

	@RequestMapping("alterarPessoa")
	public String alterar(long idPessoa, Model model) {
		DaoPessoa dao = new DaoPessoa();

		model.addAttribute("pessoas", dao.buscar(idPessoa));

		return "forward:Formpessoa";
	}

}
