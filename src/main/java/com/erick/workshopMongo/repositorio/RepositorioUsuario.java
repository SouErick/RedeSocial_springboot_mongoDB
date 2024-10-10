package com.erick.workshopMongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.erick.workshopMongo.dominio.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
	
}
