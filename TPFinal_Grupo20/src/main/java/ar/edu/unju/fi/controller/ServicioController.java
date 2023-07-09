package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/lista")
	public String getServiciosPage(Model model) {
		List<Usuario> listaUsuarios = usuarioService.getLista();
		
		model.addAttribute("listaUsuarios",listaUsuarios);
		return "servicios";
	}
	
	@GetMapping("/peso_ideal") //Nuevo PESO//
	public String getPesoIdeal(Model model) {
		
		
		
		
		return "peso_ideal";
	}
}
