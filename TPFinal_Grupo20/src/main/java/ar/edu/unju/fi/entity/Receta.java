package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recetas")
@Component
public class Receta {

	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name="recetas_id")
	private Long id;
	
	
	@Column (name="nombre_receta",nullable = false,length = 80)
	private String nombre;
	
	@Column (name="categoria_receta",nullable = false,length = 80)
	private String categoria;
	
//	@Column (name="categoria_producto",nullable = false,length = 80)
//  private String ingredientes;
	
	
	@Column (name="categoria_receta",nullable = false)
	private String preparacion;
	
	@Column
	private boolean estado;
	
	
	
	
	
	public Receta(Long id, String nombre, String categoria, String ingredientes, String preparacion, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
 //  	this.ingredientes = ingredientes;
		this.preparacion = preparacion;
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

/*	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
*/
	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
