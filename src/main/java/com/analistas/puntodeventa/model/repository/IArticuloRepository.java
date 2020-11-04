package com.analistas.puntodeventa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analistas.puntodeventa.model.domain.Articulo;

public interface IArticuloRepository extends JpaRepository<Articulo, Integer> {

}
