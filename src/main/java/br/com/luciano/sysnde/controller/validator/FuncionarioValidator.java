package br.com.luciano.sysnde.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.luciano.sysnde.model.Funcionario;

@Component
public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "", "Nome é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "email", "", "E-mail é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "telefone", "", "Telefone é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "cpf", "", "CPF é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "rg", "", "RG é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "dataAdmissao", "", "Data admissão é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "endereco.estado.id", "", "Estado é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "endereco.cidade.id", "", "Cidade é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "endereco.bairro", "", "Bairro é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "endereco.rua", "", "Rua é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "endereco.cep", "", "CEP é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "cargo.id", "", "Cargo é obrigatório");
	}

}
