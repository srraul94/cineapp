package net.srraul94.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.srraul94.app.model.Pelicula;

public interface IPeliculasService {
	
	//List<Pelicula> buscarTodas();
	
	Pelicula buscarPeliculaPorId(int idPelicula);
	
	void insertar(Pelicula pelicula);
	
	List<String> buscarGeneros();
	
	void eliminar(int idPelicula);
	
	
	Page<Pelicula> buscarTodas(Pageable page);

	List<Pelicula> buscarActivas();
}
