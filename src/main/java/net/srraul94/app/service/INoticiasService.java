package net.srraul94.app.service;
import java.util.List;

import net.srraul94.app.model.Noticia;

public interface INoticiasService {

	void guardar(Noticia noticia);

	void eliminar(int idNoticia);

	List<Noticia> buscarTodas();

	Noticia buscarPorId(int idNoticia);

	List<Noticia> buscarUltimas();
}
