package ar.edu.unju.fi.entity;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recetas")
@Component
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recetas_id")
    private Long id;

    @Column(name = "nombre_receta", nullable = false, length = 80)
    private String nombre;

    @Column(name = "categoria_receta", nullable = false, length = 80)
    private String categoria;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes;

    @Column(name = "preparacion")
    private String preparacion;

    @Column(name = "imagen")
    private String imagen;
    
    @Column(name = "estado")
    private boolean estado;

    public Receta() {
        
    }

    public Receta(Long id, String nombre, String categoria, List<Ingrediente> ingredientes, String preparacion, String imagen, boolean estado) {
    	this.id = id;
    	this.nombre = nombre;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imagen = imagen;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
    
}





