package pruebasJPA;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

//App para actualizar un objeto de la tabla Noticias.
public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//1. Buscamos el objeto mediante el método findByID
		Optional<Noticia> noticia = repository.findById(1);
		System.out.println(noticia.get());
		
		//2. Modificar el objeto obtenido.
		if(noticia.isPresent()) {
			Noticia noticiaUpdate = noticia.get();
			noticiaUpdate.setEstatus("Inactiva");
			repository.save(noticiaUpdate);
		}
		
		context.close();
	}
}
