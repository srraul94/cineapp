package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

public class AppKeywordAnd {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate=null;
		try {
			parsedDate = format.parse("2017-09-02");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		List<Noticia> lista = repository.findByEstatusAndFecha("Activa", parsedDate);
		if(lista == null) {
			System.out.println("No hay coincidencias");
		}
		for(Noticia n : lista) {
			System.out.println(n);
		}
		
		context.close();
	}

}
