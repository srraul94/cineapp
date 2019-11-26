package net.srraul94.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.srraul94.app.model.Horario;
import net.srraul94.app.model.Pelicula;
import net.srraul94.app.service.IPeliculasService;
import net.srraul94.app.util.Utileria;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model,Pageable page) {
		
		// Ejercicio: Recuperar lista de peliculas para poblar <select>
		Page<Pelicula> listaPeliculas = servicePeliculas.buscarTodas(page);
		
		// Ejercicio: agregar al modelo listado de peliculas
		model.addAttribute("peliculas",listaPeliculas);
		
		// Ejercicio: crear archivo formHorario.jsp y configurar el dise�o utilizando el codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)
		
		return "horarios/formHorario";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,Pageable page) {				
		
		// Ejercicio: Verificar si hay errores en el Data Binding
		if (result.hasErrors()) {
			Page<Pelicula> listaPeliculas = servicePeliculas.buscarTodas(page);
			model.addAttribute("peliculas", listaPeliculas);
			System.out.println("Existen errores");
			return "horarios/formHorario";
		}
		
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de model Horario 
		// que ya debera de tener los datos del formulario
		System.out.println(horario);
		
		// De momento, hacemos un redirect al mismo formulario 
		return "redirect:/horarios/create";
	}
	
	// Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date	
	
	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * @param binder
	 */
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
	}
	
}
