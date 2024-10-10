package com.erick.workshopMongo.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.servicos.ServicoUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	@Autowired
	private ServicoUsuario servico;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> acharTodos(){		
		List<Usuario> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
}
