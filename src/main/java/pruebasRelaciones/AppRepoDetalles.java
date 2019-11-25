package pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.model.Detalle;
import net.srraul94.app.repository.DetalleRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetalleRepository repository = context.getBean("detalleRepository",DetalleRepository.class);
		
		List<Detalle> lista = repository.findAll();
		
		for(Detalle d : lista) {
			System.out.println(d);
		}
		
		context.close();
	}

}
