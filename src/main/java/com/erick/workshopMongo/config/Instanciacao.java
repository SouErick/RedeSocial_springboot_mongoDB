package com.erick.workshopMongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	@Override
	public void run(String... args) throws Exception {
		repositorioUsuario.deleteAll();
		Usuario joaoFerreira = new Usuario(null, "Joao Ferreira", "joao@gmail.com");
		Usuario alessandraSilva = new Usuario(null, "Alessandra Silva", "ale@hotmail.com");
		Usuario marcosPaulo = new Usuario(null,"Marcos Paulo","mp@gmail.com");
		repositorioUsuario.saveAll(Arrays.asList(joaoFerreira, alessandraSilva, marcosPaulo));
	}

}
