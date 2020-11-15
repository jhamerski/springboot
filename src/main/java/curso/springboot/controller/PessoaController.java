package curso.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.PessoaReposiroty;

@Controller
public class PessoaController {

	@Autowired
	private PessoaReposiroty pessoaReposiroty;

	@RequestMapping(method = RequestMethod.GET, value = "cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		//return "cadastro/cadastropessoa";
		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaReposiroty.save(pessoa);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> iterable = pessoaReposiroty.findAll();
		modelAndView.addObject("pessoas", iterable);
		
		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "listapessoas")
	public ModelAndView pessoas() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> iterable = pessoaReposiroty.findAll();
		modelAndView.addObject("pessoas", iterable);
		
		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}
	
	@GetMapping("editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		Optional<Pessoa> pessoa = pessoaReposiroty.findById(idpessoa);
		modelAndView.addObject("pessoaobj", pessoa.get());
		return modelAndView;
	}
}
