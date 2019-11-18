package net.srraul94.app.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.srraul94.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<Pelicula> peliculas = getLista();
//		peliculas.add("A todo gas");
//		peliculas.add("Pokemon");
//		peliculas.add("Gran Torino");
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	@RequestMapping(value = "/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "A todo gas";
		int duracion = 136;
		double precioEntrada = 6.4;

		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("precio", precioEntrada);
		model.addAttribute("duracion", duracion);

		return "detalle";
	}

	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		
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
		}
		catch (Exception e) {
			
		}
		
		return lista;
	}

}
