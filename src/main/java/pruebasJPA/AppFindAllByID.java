package pruebasJPA;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

//Busca varios registro mediante el ID
public class AppFindAllByID {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		//recuperar varias noticas mediante sus id.
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(5);
		ids.add(2);
		ids.add(4);
		ids.add(9);
		
		Iterable<Noticia> it =  repository.findAllById(ids);
		
		for(Noticia n : it) {
			System.out.println(n);
		}
		
		
		context.close();
	}

}
