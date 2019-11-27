package net.srraul94.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Perfil;
import net.srraul94.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService{
	
	@Autowired
	private PerfilesRepository perfilesRepo;

	@Override
	public void guardar(Perfil perfil) {
		perfilesRepo.save(perfil);
		
	}

}
