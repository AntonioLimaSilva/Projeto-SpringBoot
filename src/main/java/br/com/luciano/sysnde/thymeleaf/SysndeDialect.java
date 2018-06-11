package br.com.luciano.sysnde.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.luciano.sysnde.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.luciano.sysnde.thymeleaf.processor.MessageElementTagProcessor;

@Component
public class SysndeDialect extends AbstractProcessorDialect {

	public SysndeDialect() {
		super("Sysnde Luciano", "sysnde", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		
		return processadores;
	}

}
