package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.repository.NoticiasRepository;

//Aplicacion que eliminar todas las instancias en la tabla Noticias.
public class AppDeleteAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Borrar todos los elementos de la tabla. Es muy peligroso utilizarlo!!
		repository.deleteAll();
		
		context.close();
	}
}
