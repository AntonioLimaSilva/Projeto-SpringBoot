package br.com.luciano.sysnde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luciano.sysnde.model.Cidade;
import br.com.luciano.sysnde.repository.Cidades;

@RestController
@RequestMapping("/cidades")
public class CidadesController {
	
	@Autowired
	private Cidades cidades;
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Cidade> pesquisarCidadePorEstado(@RequestParam(defaultValue = "-1") Integer idEstado) {
		return this.cidades.findByEstadoId(idEstado);
	}

}
