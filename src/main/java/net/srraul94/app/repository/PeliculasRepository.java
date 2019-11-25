package net.srraul94.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.srraul94.app.model.Pelicula;

@Repository
public interface PeliculasRepository  extends JpaRepository<Pelicula, Integer>{
	
	
}
