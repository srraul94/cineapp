package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

//Aplicacion que encuentra todas las entidades existentes en la tabla
public class AppFindAll {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//recupera todas las entidades (interfaz iterable) 
		
		Iterable<Noticia> it = repository.findAll();
		for (Noticia n : it) {
			System.out.println(n);
		}
		
		context.close();
		
	}
}
