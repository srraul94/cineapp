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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.srraul94.app.model.Horario;
import net.srraul94.app.model.Pelicula;
import net.srraul94.app.service.IHorariosService;
import net.srraul94.app.service.IPeliculasService;
import net.srraul94.app.util.Utileria;

@Controller
@RequestMapping(value = "/horarios")

public class HorariosController {
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IPeliculasService servicePeliculas;

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IHorariosService serviceHorarios;

	/**
	 * Metodo que muestra la lista de los horarios
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}

	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * 
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario) {
		return "horarios/formHorario";
	}

	/**
	 * Metodo para guardar el registro del Horario
	 * 
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}

		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		// return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}

	/**
	 * Metodo que muestra el formulario para editar un horario
	 * 
	 * @param idHorario
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}

	/**
	 * Metodo para eliminar un registro de horarios
	 * 
	 * @param idHorario
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorarios.eliminar(idHorario);
		attributes.addFlashAttribute("msg", "El horario fue eliminado!");
		// return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}

	/**
	 * Agregamos al modelo, el listado de peliculas para que este disponible para
	 * todos los metodos de este controlador
	 * 
	 * @return
	 */
	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas() {
		return servicePeliculas.buscarActivas();
	}

	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * 
	 * @param binder
	 */
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
