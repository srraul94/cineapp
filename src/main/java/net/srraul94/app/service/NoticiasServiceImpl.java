package net.srraul94.app.service;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService{
	
	public NoticiasServiceImpl() {
		System.out.println("Creando constructor NoticiasServiceImpl");
	}

	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");		
	}

	
}
