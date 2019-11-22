package pruebasJPA;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.srraul94.app.repository.NoticiasRepository;

//Cuenta el número de entidades existentes en una tabla.
public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		long num = repository.count();
		System.out.println(num);
		
		context.close();
		
	}
}
