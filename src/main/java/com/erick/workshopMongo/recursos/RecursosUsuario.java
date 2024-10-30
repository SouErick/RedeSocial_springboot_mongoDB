package com.erick.workshopMongo.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erick.workshopMongo.DTO.UsuarioDTO;
import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.servicos.ServicoUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	@Autowired
	private ServicoUsuario servico;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> acharTodos(){		
		List<Usuario> lista = servico.acharTodos();
		List<UsuarioDTO> listaDTO = lista.stream().map(novoUsuario -> new UsuarioDTO(novoUsuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> procurarPorId(@PathVariable String id){	
		Usuario obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
}
