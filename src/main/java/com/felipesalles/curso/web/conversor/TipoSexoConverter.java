package com.felipesalles.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;

import com.felipesalles.curso.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String, TipoSexo>{

	@Override
	public TipoSexo convert(String texto) {
		char tipo = texto.charAt(0);
		return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
	}

	
	
}
