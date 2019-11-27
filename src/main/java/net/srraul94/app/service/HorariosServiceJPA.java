package net.srraul94.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Horario> buscarTodos() {
		return horariosRepo.findAll();
	}
	

	@Override
	public void eliminar(int idHorario) {
		// horariosRepo.delete(idHorario); // Spring 4.3		
		horariosRepo.deleteById(idHorario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> optional = horariosRepo.findById(idHorario);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void insertar(Horario horario) {
		horariosRepo.save(horario);
	}


}
