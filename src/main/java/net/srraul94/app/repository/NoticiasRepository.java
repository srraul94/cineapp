package net.srraul94.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.srraul94.app.model.Noticia;


@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	//Select * from noticias where estatus = "estatus"
	List<Noticia> findByEstatus(String estatus);
	
	//Select * from noticias where fecha = fecha
	List<Noticia> findByFecha(Date fecha);
	
	List<Noticia> findByEstatusAndFecha(String estatus,Date fecha);
	
	List<Noticia> findByEstatusOrFecha(String estatus,Date fecha);
	
	List<Noticia> findByFechaBetween(Date fecha1,Date fecha2);

}
