package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.imp.RecetaServiceImp;

@Controller
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private RecetaServiceImp recetaService;

    @GetMapping("/listado")
    public String listarRecetas(Model model) {
        List<Receta> recetas = recetaService.getRecetas();
        model.addAttribute("recetas", recetas);
        return "recetas";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalleReceta(@PathVariable("id") Long id, Model model) {
        Receta receta = recetaService.getRecetaById(id);
        model.addAttribute("receta", receta);
        return "detalle-receta";
    }

    @GetMapping("/nueva")
    public String nuevaReceta(Model model) {
        Receta receta = new Receta();
        model.addAttribute("receta", receta);
        return "nueva-receta";
    }

    @PostMapping("/guardar")
    public String guardarReceta(@ModelAttribute("receta") Receta receta) {
        recetaService.modificarReceta(receta);
        return "redirect:/recetas/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarReceta(@PathVariable("id") Long id, Model model) {
        Receta receta = recetaService.getRecetaById(id);
        model.addAttribute("receta", receta);
        return "editar-receta";
    }

    @PostMapping("/guardar-edicion")
    public String guardarRecetaEditada(@ModelAttribute("receta") Receta receta) {
        recetaService.agregarReceta(receta);
        return "redirect:/recetas/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReceta(@PathVariable("id") Long id) {
        recetaService.deleteReceta(null);
        return "redirect:/recetas/listado";
    }
}
