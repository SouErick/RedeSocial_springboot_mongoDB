package com.erick.workshopMongo.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erick.workshopMongo.dominio.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> acharTodos(){
		Usuario teste = new Usuario("1", "Teste", "teste@email");
		Usuario teste2 = new Usuario("2", "Teste", "teste@email");
		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(teste, teste2));
		return ResponseEntity.ok().body(lista);
	}
}
