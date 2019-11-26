package pruebasJPARepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Banner;
import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.BannersRepository;
import net.srraul94.app.repository.NoticiasRepository;

public class AppFindAll {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		BannersRepository repositoryBanners = context.getBean("bannersRepository", BannersRepository.class);
		
		//Obtener todas las entidades
		List<Banner> lista = repositoryBanners.findAll();
		for(Banner b : lista) {
			System.out.println(b);
		}
		
		context.close();
		
	}

}
