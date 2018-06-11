package br.com.luciano.sysnde.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.luciano.sysnde.model.Estado;

@Component
public class EstadoConverter implements Converter<String, Estado> {

	@Override
	public Estado convert(String id) {
		if(!StringUtils.isEmpty(id)) {
			Estado estado = new Estado();
			estado.setId(Integer.valueOf(id));
			return estado;
		}
		return null;
	}

}
