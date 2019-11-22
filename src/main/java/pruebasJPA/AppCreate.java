package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;


//Aplicacion para persistir (crear) en la tabla de Noticias un objeto Noticia 
public class AppCreate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximamente: Joker 2");
		noticia.setDetalle("Tras el éxito de la primera película, se rodará su continuación");
		
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repository.save(noticia);
		context.close();
		
		
	}
}
