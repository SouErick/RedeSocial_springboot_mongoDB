package com.erick.workshopMongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erick.workshopMongo.DTO.UsuarioDTO;
import com.erick.workshopMongo.dominio.Post;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDTO){	
		Usuario obj = servico.fromDTO(objDTO);
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable String id){	
		servico.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody UsuarioDTO objDTO, @PathVariable String id){	
		Usuario obj = servico.fromDTO(objDTO);
		obj.setId(id);
		obj = servico.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> procurarPosts(@PathVariable String id){	
		Usuario obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
