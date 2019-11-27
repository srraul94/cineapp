package net.srraul94.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.srraul94.app.model.Banner;
import net.srraul94.app.model.Horario;
import net.srraul94.app.model.Noticia;
import net.srraul94.app.model.Pelicula;
import net.srraul94.app.service.IBannersService;
import net.srraul94.app.service.IHorariosService;
import net.srraul94.app.service.INoticiasService;
import net.srraul94.app.service.IPeliculasService;
import net.srraul94.app.util.Utileria;

@Controller
public class HomeController {

	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@Autowired
	private INoticiasService serviceNoticias;
	

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model, Pageable page) {

		List<String> listaFechas = Utileria.getNextDays(4);
		Page<Pelicula> peliculas = this.servicePeliculas.buscarTodas(page);
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
		model.addAttribute("peliculas", peliculas);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model,Pageable page) {

		List<String> listaFechas = Utileria.getNextDays(4);

		Page<Pelicula> peliculas = this.servicePeliculas.buscarTodas(page);

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", this.dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("horarios",this.serviceHorarios.buscarTodos());

		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha) {

		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPeliculaPorId(idPelicula));
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));

		return "detalle";
	}
	
	/**
	 * Metodo que muestra la vista de la pagina de Acerca
	 * @return
	 */
	@RequestMapping(value = "/about")
	public String mostrarAcerca() {			
		return "acerca";
	}
	
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBanners.buscarActivos();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
