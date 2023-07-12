package ar.edu.unju.fi.entity;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Component
@Table(name = "Autor")
public class AutorTestimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Autor")
	private long idAutor;
	
	@Column(name="nombre_autor")
	@NotBlank(message= "Este campo no puede estar vacio")
	@Size(min=5, max=30, message ="El nombre ser de entre 5 caracteres como minimo y 30 de maximo")
	private String nombre;
	
	@Column(name = "estado_autor")
	private boolean estado;
	
	@OneToMany(mappedBy = "autor")
	private List<Testimonio> testimonio;
	
	public AutorTestimonio() {
		super();
	}
	
	public AutorTestimonio(long idAutor,
		@NotBlank(message = "Este campo no puede estar vacio") @Size(min = 5, max = 30, message = "El nombre ser de entre 5 caracteres como minimo y 30 de maximo") String nombre,
		boolean estado, List<Testimonio> testimonio) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.estado = estado;
		this.testimonio = testimonio;
	}

	public long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Testimonio> getTestimonio() {
		return testimonio;
	}

	public void setTestimonio(List<Testimonio> testimonio) {
		this.testimonio = testimonio;
	}
	
}
