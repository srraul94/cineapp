package net.srraul94.app.service;

import org.springframework.stereotype.Service;

import net.srraul94.app.model.Detalle;

public interface IDetalleService {

	void insertar(Detalle detalle);
	void eliminar(int idDetalle);
}
