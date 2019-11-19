package net.srraul94.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.srraul94.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	private List<Pelicula> lista;
	
	public PeliculasServiceImpl() {
		System.out.println("Creando constructor");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2018"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Gran Torino");
			pelicula2.setDuracion(240);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Drama");
			pelicula2.setFechaEstreno(formatter.parse("14-10-2016"));
			pelicula2.setImagen("grantorino.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Spider-Man");
			pelicula3.setDuracion(240);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Accion");
			pelicula3.setFechaEstreno(formatter.parse("22-08-2017"));
			pelicula3.setImagen("spiderman.png");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("The Green Book");
			pelicula4.setDuracion(240);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Drama");
			pelicula4.setFechaEstreno(formatter.parse("22-08-2018"));
			pelicula4.setEstatus("Inactiva");
			pelicula4.setImagen("greenbook.png");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return this.lista;
	}

	@Override
	public Pelicula buscarPeliculaPorId(int idPelicula) {
		
		for(Pelicula p : this.lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

}
