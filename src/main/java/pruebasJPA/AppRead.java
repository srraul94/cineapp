package pruebasJPA;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;


//App para read (leer) un objeto de la tabla Noticias.
public class AppRead {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Leemos mediante el método findByID
		
		Optional<Noticia> noticia = repository.findById(1);
		
		System.out.println(noticia.get());
		
		
		context.close();
	}
}
