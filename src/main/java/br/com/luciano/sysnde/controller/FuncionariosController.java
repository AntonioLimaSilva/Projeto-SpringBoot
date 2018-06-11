package br.com.luciano.sysnde.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.luciano.sysnde.controller.validator.FuncionarioValidator;
import br.com.luciano.sysnde.model.Funcionario;
import br.com.luciano.sysnde.repository.Cargos;
import br.com.luciano.sysnde.repository.Estados;
import br.com.luciano.sysnde.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {
	
	@Autowired
	private Estados estados;
	
	@Autowired
	private Cargos cargos;
	
	@Autowired
	private FuncionarioValidator validator;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@InitBinder("funcionario")
	public void inicializar(WebDataBinder binder) {
		binder.setValidator(this.validator);
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("funcionario/CadastroFuncionario");
		
		mv.addObject("cargos", this.cargos.findAll());
		mv.addObject("estados", this.estados.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView inserir(Funcionario funcionario, BindingResult result) {
		this.validator.validate(funcionario, result);
		
		if(result.hasErrors()) {
			return novo(funcionario);
		}
		
		this.funcionarioService.salvar(funcionario);
		
		return new ModelAndView("redirect:/funcionarios/novo");
	}
}
