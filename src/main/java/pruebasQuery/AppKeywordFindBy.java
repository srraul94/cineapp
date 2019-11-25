package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

public class AppKeywordFindBy {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Ejemplo de KeywordFind estatus
		List<Noticia> lista = repository.findByEstatus("Activa");

		for (Noticia n : lista) {
			//System.out.println(n);
		}

		// Ejemplo de KeywordFind fecha
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			List<Noticia> lista2 = repository.findByFecha(format.parse("2017-09-01"));

			for (Noticia n : lista2) {
				System.out.println(n);
			}
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		context.close();
	}

}
