package com.analistas.puntodeventa.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.puntodeventa.model.domain.Articulo;
import com.analistas.puntodeventa.model.repository.IArticuloRepository;

@Service
public class ArticuloServiceImpl implements IArticuloService {

	@Autowired
	IArticuloRepository articuloRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> buscarTodo() {
		
		return articuloRepo.findAll();
	}

	@Override
	public List<Articulo> buscarPor(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Articulo articulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub

	}

}
