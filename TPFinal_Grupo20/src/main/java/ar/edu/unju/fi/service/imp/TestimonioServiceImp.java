package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;

@Service("testimonioServiceImp")
public class TestimonioServiceImp implements ITestimonioService {
	@Autowired
	private ITestimonioRepository testimonioRepository;
	
	
	@Override
	public List <Testimonio> getLista(){
		return testimonioRepository.findByestado(true);
	}
	
	public void guardar(@Valid Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
	}
	
	public Testimonio getBy(Long id) {
		return testimonioRepository.findById(id).get();
	}
	
	@Override
	public void modificar(@Valid Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
	}
	
	@Override
	public void eliminar(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
	}

	@Override
	public List<Testimonio> getList() {
		return null;
	}

	@Override
	public Testimonio getBy(long idTestimonio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonio getTestimonio() {
		return null;
	}
	
	
}
