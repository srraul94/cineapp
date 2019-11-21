package net.srraul94.app.service;

import java.util.List;
import net.srraul94.app.model.Banner;

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
