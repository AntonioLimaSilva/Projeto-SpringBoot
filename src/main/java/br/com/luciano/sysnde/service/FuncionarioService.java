package br.com.luciano.sysnde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luciano.sysnde.model.Funcionario;
import br.com.luciano.sysnde.repository.Funcionarios;

@Service
public class FuncionarioService {
	
	@Autowired
	private Funcionarios funcionarios;
	
	public void salvar(Funcionario funcionario) {
		
		this.funcionarios.save(funcionario);
	}

}
