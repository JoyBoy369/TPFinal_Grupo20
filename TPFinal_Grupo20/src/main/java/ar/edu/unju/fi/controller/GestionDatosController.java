package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IImcService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/gestion")
public class GestionDatosController {

	
	@Autowired
	private IImcService imcService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("")
	public String getServiciosPage(Model model,@Param("idbuscar")Long idbuscar) { //Lista//
		
		List<Usuario> listaUsuarios = usuarioService.getBuscar(idbuscar);
		
		List<IndiceMasaCorporal> listaImc = imcService.getLista();
		
		model.addAttribute("listaImc",listaImc);
		model.addAttribute("listaUsuarios",listaUsuarios);
		model.addAttribute("idbuscar",idbuscar);
		
		return "gestion_datos";
	}
	
	@GetMapping("/nuevo_usuario")
	public String getNuevoUsuarioForm(Model model) {
		boolean editar = false;
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("editar", editar);
		
		return "nuevo_usuario";
	}
	
	@PostMapping("/guardar_usuario")
	public String guardarNewUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult resultado,Model model) {
		if (resultado.hasErrors()) {
	        model.addAttribute("usuario", usuario);
	        return "nuevo_usuario";
	    }
		usuario.setEstado(true);
		usuarioService.guardar(usuario);
		model.addAttribute("usuario", usuarioService.getLista());
		
		return  "redirect:/gestion/lista";
		}
	
	@GetMapping("/nuevo_imc")
	public String getNuevoIMCForm(Model model) {
		boolean editar = false;
		List<Usuario> listaUsuarios = usuarioService.getLista();
		
		model.addAttribute("listaUsuarios",listaUsuarios);
		model.addAttribute("indicemc", new IndiceMasaCorporal ());
		model.addAttribute("editar", editar);
		
		return "nuevo_imc";
	}
	
	@PostMapping("/guardar_imc")
	public String guardarNewImc(@Valid @ModelAttribute("imc") IndiceMasaCorporal imc, BindingResult resultado,Model model) {
		if (resultado.hasErrors()) {
	        model.addAttribute("imc", imc);
	        return "nuevo_imc";
	    }
		imc.setEstado(true);
		imcService.guardar(imc);
		System.out.print(imc);
		model.addAttribute("imc",imcService.getLista());
		
		return  "redirect:/gestion";
		
	}
	
}

