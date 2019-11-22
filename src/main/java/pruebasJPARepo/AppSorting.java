package pruebasJPARepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

public class AppSorting {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Obtener todas ordenadas por un campo concreto.
		List<Noticia> lista = repository.findAll(Sort.by("titulo").descending());
		for(Noticia n : lista) {
			System.out.println(n);
		}
		
		List<Noticia> lista2 = repository.findAll(Sort.by("fecha").ascending().and(Sort.by("titulo").ascending()));
		for(Noticia n : lista2) {
			System.out.println(n);
		}
		
		
		context.close();
	}

}
