package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de testimonios.
 */
@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

	@Autowired
	Testimonio testimonio;
	
	@Autowired
	@Qualifier("testimonioServiceImp")
	private ITestimonioService testimonioService;
	
	/**
	 * Mapeo para obtener la página de listado de testimonios.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "testimonios"
	 */
	@GetMapping("/listadoDeTestimonio")
	public String getTestimonioPage(Model model) {
		List<Testimonio> listaTestimonios = testimonioService.getLista();
		model.addAttribute("testimonios", listaTestimonios);
		return "testimonios";
	}
	
	/**
	 * Mapeo para obtener la página de creación de un nuevo testimonio.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_testimonio"
	 */
	@GetMapping("/nuevo_Testimonio")
	public String getNuevoTestimonio(Model model) {
		 boolean editar = false;
		 model.addAttribute("testimonio",testimonioService.getTestimonio());
		 model.addAttribute("editar", editar);
		 return "nuevo_testimonio";
	}
	
	/**
	 * Mapeo para guardar un nuevo testimonio.
	 * @param el consejo a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "testimonio" si no hay errores, o "nuevo_testimonio" en caso contrario
	 */
	@PostMapping("guardar_Testimonio")
	public ModelAndView guardarTestimonio(@Valid @ModelAttribute("testimonio")Testimonio testimonio, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView("testimonios");
		if(resultado.hasErrors()) {
			modelView.setViewName("nuevo_testimonio");
			modelView.addObject("testimonio", testimonio);
			return modelView;
		}
		testimonio.setEstado(true);
		testimonioService.guardar(testimonio);
		modelView.setViewName("testimonios");
		modelView.addObject("testimonio", testimonioService.getLista());
		return modelView;
	}
	
	/**
	 * Mapeo para obtener la página de edición de un testimonio.
	 * @param model el modelo de la vista
	 * @param nombre el nombre del testimonio a editar
	 * @return el nombre de la vista "nuevo_Testimonio"
	 */
	@GetMapping("/editar/{idTestimonio}")
	public ModelAndView getEditarTestimonio(Model model, @PathVariable(value = "idTestimonio") Long idTestimonio) {
		ModelAndView modelView = new ModelAndView("nuevo_testimonio");
		Testimonio testimonioEncontrado = testimonioService.getBy(idTestimonio);
		boolean editar = true;
		modelView.addObject("testimonio", testimonioEncontrado);
		modelView.addObject("editar", editar);
		return modelView;
	}
	
	/**
	 * Mapeo para guardar los cambios de un testimonio editado.
	 * @param consejo el testimonio editado
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_testimonio" si hay errores, o "redirect:/sucursales/listado" en caso contrario
	 */
	@PostMapping("/editar")
	public String editarTestimonio(@Valid @ModelAttribute("testimonio")Testimonio testimonio, BindingResult resultado, Model model) {
		if(resultado.hasErrors()){
			boolean editar = true;
			model.addAttribute("editar", editar);
			return "nuevo_testimonio";
		}
		testimonioService.modificar(testimonio);
		return "redirect:/testimonios/listado";
	}
	
	/**
	 * Mapeo para eliminar un testimonio.
	 * @param nombre el nombre del testimonio a eliminar
	 * @return el nombre de la vista "redirect:/testimonios/listado"
	 */
	@GetMapping("/eliminar/{idTestimonio}")
	public String eliminarTestimonio(@PathVariable(value = "idTestimonio") long idtestimonio) {
		Testimonio testimonioEncontrado = testimonioService.getBy(idtestimonio);
		testimonioService.eliminar(testimonioEncontrado);
		return "redirect:/testimonios/listado";
	}
}
