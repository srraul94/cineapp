package pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Pelicula;
import net.srraul94.app.repository.PeliculasRepository;

public class AppFindAll {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repository = context.getBean("peliculasRepository",PeliculasRepository.class);
		
		
		List<Pelicula> lista = repository.findAll();
		
		for(Pelicula p : lista) {
			System.out.println(p);
		}
		
		context.close();
	}

} 
