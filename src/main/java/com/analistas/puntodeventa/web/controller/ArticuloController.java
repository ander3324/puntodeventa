package com.analistas.puntodeventa.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.analistas.puntodeventa.model.domain.Articulo;
import com.analistas.puntodeventa.model.service.IArticuloService;

@Controller
@RequestMapping("/articulos")
@SessionAttributes({"articulo"})
public class ArticuloController {
	
	@Autowired
	IArticuloService articuloService;
	
	@GetMapping("/list")
	public String home(Model model) {
		
		model.addAttribute("titulo", "Sistema de Punto de Venta");
		model.addAttribute("articulos", articuloService.buscarTodo());
		
		return "articulos/list";
	}
	
	@GetMapping("/form")
	public String nuevo(Model model) {
		
		model.addAttribute("articulo", new Articulo());
		model.addAttribute("titulo", "Nuevo Artículo");
		
		return "articulos/form";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		Articulo articulo = articuloService.buscarPorId(id);
		
		model.addAttribute("articulo", articulo);
		model.addAttribute("titulo", "Editar Artículo");
		
		return "articulos/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Articulo articulo, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors())
			return "articulos/form";
		
		if(articulo.getId() == 0)
			flash.addFlashAttribute("success", "Artículo Creado.");
		else
			flash.addFlashAttribute("warning", "Artículo Modificado.");
		
		articuloService.guardar(articulo);
		status.setComplete();
		
		return "redirect:/articulos/list";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable int id, Model model, RedirectAttributes flash) {
		
		articuloService.borrar(id);
		
		flash.addFlashAttribute("danger", "Artículo Borrado.");
		
		return "redirect:/articulos/list";
	}

}
