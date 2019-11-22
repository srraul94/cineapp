package net.srraul94.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.srraul94.app.model.Noticia;


@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
