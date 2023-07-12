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
import ar.edu.unju.fi.entity.AutorTestimonio;
import ar.edu.unju.fi.service.IAutorService;



@Controller
@RequestMapping("/autor")
public class AutorTestimonioController {

    @Autowired
    private IAutorService autorService;



    /**
     * Muestra la página de autores.
     *
     * @param model El modelo utilizado para pasar datos a la vista
     * @return La vista "autor.html" que muestra la página de autores
     */
    @GetMapping("/listado")
    public String listaAutores(Model model) {
        List<AutorTestimonio> autores = autorService.getListAllAutores();
        model.addAttribute("autores", autores);
        return "autor";
    }

    /**
     * Muestra la página para agregar un nuevo autor.
     *
     * @param model El modelo utilizado para pasar datos a la vista
     * @return La vista "nuevo-autor.html" para agregar un nuevo autor
     */
    @GetMapping("/nuevo")
    public String nuevoAutor(Model model) {
        AutorTestimonio autor = new AutorTestimonio();
        model.addAttribute("autor", autor);
        return "nuevo_autor";
    }

    /**
     * Agrega un nuevo autor.
     *
     * @param autor El autor a agregar
     * @return La redirección a la página de autores ("/autor/listado")
     */
    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute("autor") AutorTestimonio autor) {
        autorService.addAutorTest(autor);
        return "redirect:/autor/listado";
    }

    /**
     * Elimina un autor según su ID.
     *
     * @param id    El ID del autor a eliminar
     * @param model El modelo utilizado para pasar datos a la vista
     * @return La redirección a la página de autores ("/autor/listado")
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable("id") long id, Model model) {
        AutorTestimonio autor = autorService.findAutorById(id);
        if (autor != null) {
            autorService.eliminarAutorTestimonio(autor);
        }
        return "redirect:/autor/listado";
    }

    /**
     * Muestra la página para editar un autor según su ID.
     *
     * @param id    El ID del autor a editar
     * @param model El modelo utilizado para pasar datos a la vista
     * @return La vista "editar-autor.html" para editar un autor
     */
    @GetMapping("/editar/{id}")
    public String editarAutor(@PathVariable("id") long id, Model model) {
        AutorTestimonio autor = autorService.findAutorById(id);
        if (autor != null) {
            model.addAttribute("autor", autor);
            return "editar_autor";
        } else {
            return "redirect:/autor/listado";
        }
    }

    /**
     * Guarda los cambios realizados en un autor editado.
     *
     * @param autor El autor editado a guardar
     * @return La redirección a la página de autores ("/autor/listado")
     */
    @PostMapping("/guardar-edicion")
    public String guardarAutorEditado(@ModelAttribute("autor") AutorTestimonio autor) {
        autorService.addAutorTest(autor);
        return "redirect:/autor/listado";
    }
}


