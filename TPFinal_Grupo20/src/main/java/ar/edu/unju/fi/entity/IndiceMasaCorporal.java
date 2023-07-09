package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Component
@Table(name = "masa_corporal")
public class IndiceMasaCorporal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="imc_id")
	private Long id;
	
	
	@Past(message = "ingrese una fecha valida")
	@NotNull(message = "No puede estar nulo la fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="imc_date")
	private LocalDate fechaimc;
	
	@Column(name = "imc_value")
	private double peso;
	
	
	@Autowired
	@JoinColumn(name = "user_id" )
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Usuario usuario;

	@Column(name="imc_state")
	private boolean estado;

	
	
	
	public String getCalcularIMC(){
		
		
		LocalDate nacimiento= usuario.getFecha();
		LocalDate hoy;
		hoy= LocalDate.now();
		Period periodo = Period.between(nacimiento,hoy);
		int edad=periodo.getYears();
		
		double altura = usuario.getAltura();
		double masacorp;
		
		masacorp = peso/(altura*altura);
		
		if(masacorp<18.5) {
			masacorp=Math.round(masacorp);
			return "Esta por debajo de su peso ideal. IMC: "+masacorp;}
		
		else
			if(masacorp>=18.5 && masacorp <=25) {
				masacorp=Math.round(masacorp);
				return "Esta en su Peso ideal IMC: "+masacorp;}
		
			else {
				masacorp=Math.round(masacorp);
				return "Tiene Sobrepeso. IMC: "+masacorp;}
		
		
		
		
	}
	
	
	
	public IndiceMasaCorporal() {
	
	}


	public IndiceMasaCorporal(Long id, LocalDate fechaimc, double peso, Usuario usuario,boolean estado) {
		super();
		this.id = id;
		this.fechaimc = fechaimc;
		this.peso = peso;
		this.usuario = usuario;
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getFechaimc() {
		return fechaimc;
	}


	public void setFechaimc(LocalDate fechaimc) {
		this.fechaimc = fechaimc;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
