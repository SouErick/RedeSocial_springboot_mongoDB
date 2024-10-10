package com.erick.workshopMongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {
	@Autowired
	private RepositorioUsuario repo;
	public List<Usuario> acharTodos(){
		return repo.findAll();
	}
}
