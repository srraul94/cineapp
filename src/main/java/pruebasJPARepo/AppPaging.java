package pruebasJPARepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int numPag = 0;
		int numRegistros = 5;
		Page<Noticia> pagina = repository.findAll(PageRequest.of(numPag, numRegistros));
		
		for(Noticia n : pagina) {
			System.out.println(n);
		}
		
		Page<Noticia> paginaOrdenada = repository.findAll(PageRequest.of(numPag, numRegistros,Sort.by("titulo").ascending()));
		
		for(Noticia n : paginaOrdenada) {
			System.out.println(n);
		}
		
		
		context.close();
	}
}
