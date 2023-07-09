package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tabla_usuario")
@Component
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;

	//@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="user_name")
	private String nombre;
	
	//@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="user_apellido")
	private String apellido;
	
	//@Email(message = "Ingrese un correo valido")
	//@NotEmpty(message = "No puede estar vacio el correo")
	@Column(name="user_mail")
	private String correo;
	
	
	//@Past(message = "ingrese una fecha valida")
	//@NotNull(message = "No puede estar nulo la fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="usar_date")
	private LocalDate fecha;
	


	//@Size(min=10,max=18,message = "Ingrese un telefono valido Ej:3880934183")
	@Column(name="user_phone")
	private String telefono;
	
	//@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="user_genero")
	private String genero;
	
	//@Positive(message = "Ingrese una altura valida")
	@Column(name="user_altura")
	private double altura;
	
	//@NotNull(message = "Campo Obligatorio")
	@Column(name="user_DNI")
	private String dni;
	
	
	@Column(name="user_state")
	private boolean estado;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
	private List<IndiceMasaCorporal> imc;
	
	
	public Usuario() {
		
	}

	
	public Usuario(Long id,String nombre, String apellido, String correo, LocalDate fecha, String telefono, String genero, double altura, String dni,boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fecha = fecha;
		this.telefono = telefono;
		this.genero = genero;
		this.altura = altura;
		this.dni = dni;
		this.estado = estado;
	}

	
	public double getPesoIdeal() {
		
		LocalDate hoy;
		hoy= LocalDate.now();
		Period periodo = Period.between(fecha,hoy);
		int edad=periodo.getYears();	
		return (altura*100)-100+((edad/10)*0.9);
	}
	


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	
	
	
	@Override
	public String toString() {
		return "Usuario [getPesoIdeal()=" + getPesoIdeal() + "]";
	}
	
	
	
	
	
	
}
