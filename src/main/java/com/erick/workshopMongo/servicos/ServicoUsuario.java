package com.erick.workshopMongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.workshopMongo.DTO.UsuarioDTO;
import com.erick.workshopMongo.dominio.Usuario;
import com.erick.workshopMongo.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {
	@Autowired
	private RepositorioUsuario repo;
	public List<Usuario> acharTodos(){
		return repo.findAll();
	}
	public Usuario procurarPorId(String id) {
	    Optional<Usuario> usuario = repo.findById(id);
	    return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado."));
	}
	public Usuario inserir(Usuario obj) {
		return repo.insert(obj);
	}
	public void remover(String id) {
		procurarPorId(id);
		repo.deleteById(id);
	}
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}
}
