package curso.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.PessoaReposiroty;

@Controller
public class PessoaController {

	@Autowired
	private PessoaReposiroty pessoaReposiroty;

	@RequestMapping(method = RequestMethod.GET, value = "cadastropessoa")
	public String inicio() {
		return "cadastro/cadastropessoa";
	}

	@RequestMapping(method = RequestMethod.POST, value = "salvarpessoa")
	public String salvar(Pessoa pessoa) {
		pessoaReposiroty.save(pessoa);
		return "cadastro/cadastropessoa";
	}

}
