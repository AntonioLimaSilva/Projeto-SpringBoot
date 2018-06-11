package br.com.luciano.sysnde.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luciano.sysnde.model.Cidade;

@Repository
public interface Cidades extends JpaRepository<Cidade, Integer> {
	
	List<Cidade> findByEstadoId(Integer idEstado);

}
