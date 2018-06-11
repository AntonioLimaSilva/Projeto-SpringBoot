package br.com.luciano.sysnde.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.StringUtils;

import br.com.luciano.sysnde.model.Cargo;

@Component
public class CargoConverter implements Converter<String, Cargo> {

	@Override
	public Cargo convert(String id) {
		if(!StringUtils.isEmpty(id)) {
			Cargo cargo = new Cargo();
			cargo.setId(Integer.valueOf(id));
			return cargo;
		}
		return null;
	}

}
