package com.erick.workshopMongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.erick.workshopMongo.dominio.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {
	
}
