package net.srraul94.app.service;

import java.util.List;
import net.srraul94.app.model.Pelicula;

public interface IPeliculasService {
	
	List<Pelicula> buscarTodas();
	Pelicula buscarPeliculaPorId(int idPelicula);
	void insertar(Pelicula pelicula);
	List<String> buscarGeneros();
	
}
