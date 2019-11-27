package net.srraul94.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Pelicula;
import net.srraul94.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService{

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	/*@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}*/

	@Override
	public Pelicula buscarPeliculaPorId(int idPelicula) {
		Optional<Pelicula> pelicula = peliculasRepo.findById(idPelicula);
		if(pelicula.isPresent()) {
			return pelicula.get();
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Clasicas");
		generos.add("Aventura");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}

	@Override
	public List<Pelicula> buscarActivas() {
		// TODO Auto-generated method stub
		return null;
	}

}
