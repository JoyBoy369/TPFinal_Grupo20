package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;





public interface IImcService {

	
	
	List<IndiceMasaCorporal> getLista();
	
	void guardar(IndiceMasaCorporal imc);
	
	
	IndiceMasaCorporal getby(Long id);
	
	void modificar(IndiceMasaCorporal imc);
	
	void eliminar (IndiceMasaCorporal imc);
	
	IndiceMasaCorporal getImc();
	
}


