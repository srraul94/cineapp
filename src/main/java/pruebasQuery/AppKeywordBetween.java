package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Noticia;
import net.srraul94.app.repository.NoticiasRepository;

public class AppKeywordBetween {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate1=null;
		Date parsedDate2=null;
		try {
			parsedDate1 = format.parse("2017-09-01");
			parsedDate2 = format.parse("2017-09-10");
			
			List<Noticia> lista = repository.findByFechaBetween(parsedDate1,parsedDate2);
			for(Noticia n : lista) {
				System.out.println(n);
			}
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		context.close();
	}
}
