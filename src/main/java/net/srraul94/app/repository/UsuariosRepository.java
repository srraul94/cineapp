package net.srraul94.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.srraul94.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	
	

}
