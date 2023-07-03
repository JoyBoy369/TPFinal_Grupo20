package ar.edu.unju.fi.entity;

import java.util.Date;

public class Testimonio {
	private int idTestimonio;
	private Date fecha;
	private String comentario;
	
	public Testimonio(){
		
	}
	
	public Testimonio(int idTestimonio, Date fecha, String comentario) {
		super();
		this.idTestimonio = idTestimonio;
		this.fecha = fecha;
		this.comentario = comentario;
	}

	public int getIdTestimonio() {
		return idTestimonio;
	}

	public void setIdTestimonio(int idTestimonio) {
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
	
	
	
}
