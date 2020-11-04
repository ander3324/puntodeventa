package com.analistas.puntodeventa.model.service;

import java.util.List;

import com.analistas.puntodeventa.model.domain.Articulo;

public interface IArticuloService {

	public List<Articulo> buscarTodo();
	
	public List<Articulo> buscarPor(String texto);
	
	public Articulo buscarPorId(Integer id);
	
	public void guardar(Articulo articulo);
	
	public void borrar(Integer id);
	
}
