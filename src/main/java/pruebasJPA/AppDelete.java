package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.repository.NoticiasRepository;

//Aplicacion que sirve para borrar una entidad de la tabla Noticias
public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Utilizamos deleteByID que lo borrar de la base de datos.
		int idNoticia = 1;
		
		if(repository.existsById(idNoticia)) {
			repository.deleteById(idNoticia);
		}
		else {
			System.out.println("No existe noticia con el ID " +idNoticia);
		}
		
		
		
		context.close();
	}
}
