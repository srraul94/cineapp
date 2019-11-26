package net.srraul94.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Detalle;
import net.srraul94.app.repository.DetalleRepository;

@Service
public class DetallesServiceJPA implements IDetalleService{
	
	@Autowired
	private DetalleRepository detallesRepo;

	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
		
	}

	@Override
	public void eliminar(int idDetalle) {
		detallesRepo.deleteById(idDetalle);
		
	}

}
