package com.erick.workshopMongo.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erick.workshopMongo.dominio.Post;
import com.erick.workshopMongo.servicos.ServicoPost;

@RestController
@RequestMapping(value="/posts")
public class RecursosPost {
	@Autowired
	private ServicoPost servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> procurarPorId(@PathVariable String id){	
		Post obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
