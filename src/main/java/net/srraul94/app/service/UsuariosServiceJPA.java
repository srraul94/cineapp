package net.srraul94.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Usuario;
import net.srraul94.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService{

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

}
