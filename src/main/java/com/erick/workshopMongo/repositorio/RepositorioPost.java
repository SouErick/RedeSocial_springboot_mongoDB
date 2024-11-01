package com.erick.workshopMongo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.erick.workshopMongo.dominio.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {
	List<Post> findByTituloContainingIgnoreCase(String text);
	@Query("{'titulo': {$regex: ?0, $options: 'i'}}")
	List<Post> procurarTitulo(String text);
}
