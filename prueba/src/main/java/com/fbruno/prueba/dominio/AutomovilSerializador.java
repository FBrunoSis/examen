package com.fbruno.prueba.dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class AutomovilSerializador extends StdSerializer<List<Automovil>>  {

	protected AutomovilSerializador(Class<List<Automovil>> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(List<Automovil> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		List<Automovil> automoviles = new ArrayList<>();;
		for (Automovil a : value) {
			a.setOpcionales(null);
			automoviles.add(a);
		}
		gen.writeObject(automoviles);
}
}
