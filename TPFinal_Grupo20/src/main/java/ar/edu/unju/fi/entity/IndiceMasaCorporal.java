package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
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
@Table(name = "masa_corporal")
@Component
public class IndiceMasaCorporal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imc_id")
	private Long id;

	@Past(message = "Ingrese una fecha válida")
	@NotNull(message = "La fecha no puede ser nula")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "imc_date")
	private LocalDate fechaimc;

	@Column(name = "imc_value", columnDefinition = "float")
	private double peso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Usuario usuario;

	@Column(name = "imc_state")
	private boolean estado;

	public String getCalcularIMC() {
		double altura = usuario.getAltura();
		double masacorp;

		masacorp = peso / (altura * altura);

		if (masacorp < 18.5) {
			masacorp = Math.round(masacorp);
			return "Está por debajo de su peso ideal. IMC: " + masacorp;
		} else if (masacorp >= 18.5 && masacorp <= 25) {
			masacorp = Math.round(masacorp);
			return "Está en su peso ideal. IMC: " + masacorp;
		} else {
			masacorp = Math.round(masacorp);
			return "Tiene sobrepeso. IMC: " + masacorp;
		}
	}

	public IndiceMasaCorporal() {

	}

	public IndiceMasaCorporal(Long id, LocalDate fechaimc, double peso, Usuario usuario, boolean estado) {
		this.id = id;
		this.fechaimc = fechaimc;
		this.peso = peso;
		this.usuario = usuario;
		this.estado = estado;
	}

	// Getters y setters

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
