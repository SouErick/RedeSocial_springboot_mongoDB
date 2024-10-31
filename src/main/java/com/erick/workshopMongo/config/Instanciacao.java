package com.erick.workshopMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.erick.workshopMongo.DTO.AutorDTO;
import com.erick.workshopMongo.dominio.Post;
import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.repositorio.RepositorioPost;
import com.erick.workshopMongo.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPost repositorioPost;
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		repositorioUsuario.deleteAll();
		repositorioPost.deleteAll();
		Usuario joaoFerreira = new Usuario(null, "Joao Ferreira", "joao@gmail.com");
		Usuario alessandraSilva = new Usuario(null, "Alessandra Silva", "ale@hotmail.com");
		Usuario marcosPaulo = new Usuario(null,"Marcos Paulo","mp@gmail.com");
		repositorioUsuario.saveAll(Arrays.asList(joaoFerreira, alessandraSilva, marcosPaulo));
		Post post1 = new Post(null, sdf.parse("30/10/2024"), "Nova rede social!", "Tem que programar para postar um comentário...", new AutorDTO(marcosPaulo));
		Post post2 = new Post(null, sdf.parse("01/11/2024"), "Ano acabando", "Meu Deus, o ano já tá acabando D:", new AutorDTO(alessandraSilva));
		repositorioPost.saveAll(Arrays.asList(post1, post2));
	}

}
