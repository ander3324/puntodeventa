package com.analistas.puntodeventa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.analistas.puntodeventa.model.service.IArticuloService;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	IArticuloService articuloService;
	
	@GetMapping("/list")
	public String home(Model model) {
		
		model.addAttribute("titulo", "Sistema de Punto de Venta");
		model.addAttribute("articulos", articuloService.buscarTodo());
		
		return "articulos/list";
	}

}
