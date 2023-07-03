package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Testimonio;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

	@GetMapping("/mostrar")
	public String getTestimoniosPage(Model model) {
		Testimonio nuevoComentario = new Testimonio();
		model.addAttribute("testimonio", nuevoComentario);
		return "testimonios";
	}
	
	/*@GetMapping("/guardar_Comentario")
	public ModelAndView getGuardarComentaio() {
		ModelAndView modelviView = new ModelAndView("comentarios");
		
	}*/
		
}
