package com.erick.workshopMongo.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.workshopMongo.dominio.Post;
import com.erick.workshopMongo.repositorio.RepositorioPost;

@Service
public class ServicoPost {
	@Autowired
	private RepositorioPost repo;
	public Post procurarPorId(String id) {
	    Optional<Post> usuario = repo.findById(id);
	    return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado."));
	}
	public List<Post> procurarPorTitulo(String text){
		return repo.procurarTitulo(text);
	}
	public List<Post> procurarTudo(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 10000);
		return repo.procurarTudo(text, minDate, maxDate);
	}
}
