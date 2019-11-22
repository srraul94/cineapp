package pruebasJPA;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

//App que comprueba si un determinado objeto existe en la tabla Noticias.
public class AppExists {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Hacemos un consulta rapida para ver si existe.
		int idNoticia = 1;
		boolean resultado = repository.existsById(idNoticia);
		System.out.println(resultado);
		
		
		context.close();
	}
}
