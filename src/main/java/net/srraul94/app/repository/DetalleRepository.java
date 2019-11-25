package net.srraul94.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.srraul94.app.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer>{
	

}
