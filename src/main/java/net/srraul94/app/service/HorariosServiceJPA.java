package net.srraul94.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.srraul94.app.model.Horario;
import net.srraul94.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService {
	
	@Autowired
	private HorariosRepository horariosRepo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

}
