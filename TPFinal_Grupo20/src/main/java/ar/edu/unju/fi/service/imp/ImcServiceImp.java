package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.ImcRepository;
import ar.edu.unju.fi.service.IImcService;

@Service("imcserviceimp")
public class ImcServiceImp implements IImcService {

	@Autowired
	private ImcRepository imcRepository;
	
	@Autowired
	private IndiceMasaCorporal imc;
	
	
	@Override
	public List<IndiceMasaCorporal> getLista(){
		
		return imcRepository.findByEstado(true);
	}
	
	public void guardar(IndiceMasaCorporal imc){
		imcRepository.save(imc);
	}
	
	
	
	public IndiceMasaCorporal getby(Long id) {
		
		return imcRepository.findById(id).get();
	}
	
	
	public void modificar(IndiceMasaCorporal imc) {
		imc.setEstado(true);
		imcRepository.save(imc);
	}
	
	public void eliminar (IndiceMasaCorporal imcEncontrado) {
		
		imcEncontrado.setEstado(false);
		imcRepository.save(imcEncontrado);
	}
	
	public IndiceMasaCorporal getImc() {
		return imc;
	}
	
}
