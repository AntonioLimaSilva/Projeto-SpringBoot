package br.com.luciano.sysnde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luciano.sysnde.model.Funcionario;

@Repository
public interface Funcionarios extends JpaRepository<Funcionario, Integer> {

}
