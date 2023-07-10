package ar.edu.unju.fi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "Testimonio")
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Testimonio")
	private long idTestimonio;
	
	
	@NotEmpty(message = "La fecha no puede estar vacia")
	@Column(name = "Fecha", columnDefinition = "datetime")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fecha;
	
	@Column(name ="comentario")
	@NotBlank(message = "El espacio no puede quedar vacio")
	@Size(min = 4, max = 500, message = "El mensaje no puede ser muy corto, a que nos servira para poder mejorar la experiencia de usuario. ")
	private String comentario;
	
	@Column
	private boolean estado;
	
	public Testimonio(){
		
	}
	
	public Testimonio(long idTestimonio, Date fecha, String comentario, boolean estado) {
		super();
		this.idTestimonio = idTestimonio;
		this.fecha = fecha;
		this.comentario = comentario;
		this.estado = estado;
	}

	public long getIdTestimonio() {
		return idTestimonio;
	}

	public void setIdTestimonio(long idTestimonio) {
		this.idTestimonio = idTestimonio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
