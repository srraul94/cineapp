package net.srraul94.app.service;

import java.util.Date;
import java.util.List;

import net.srraul94.app.model.Horario;

public interface IHorariosService {

	List<Horario> buscarPorIdPelicula(int idPelicula,Date fecha);

	List<Horario> buscarTodos();

	void insertar(Horario horario);

	Horario buscarPorId(int idHorario);

	void eliminar(int idHorario);
}
