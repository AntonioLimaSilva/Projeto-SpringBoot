package br.com.luciano.sysnde.format;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Locale;

import org.springframework.format.Formatter;

public abstract class TemporalFormatter<T extends Temporal> implements Formatter<T> {

	@Override
	public String print(T temporal, Locale locale) {
		DateTimeFormatter formatter = getDateTimeFormatter(locale);
		return formatter.format(temporal);
	}
	
	@Override
	public T parse(String text, Locale locale) throws ParseException {
		DateTimeFormatter formatter = getDateTimeFormatter(locale);
		return parse(text, formatter);
	}
	
	public abstract T parse(String text, DateTimeFormatter formatter);
	
	public abstract String pattern(Locale locale);
	
	private DateTimeFormatter getDateTimeFormatter(Locale locale) {
		return DateTimeFormatter.ofPattern(pattern(locale));
	}

}
