package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.AutorTestimonio;
import ar.edu.unju.fi.repository.AutorRepository;
import ar.edu.unju.fi.service.IAutorService;

@Service("AutorServiceImp")
public class AutorServiceImp implements IAutorService {
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<AutorTestimonio> getListAllAutores() {
		return (List<AutorTestimonio>) autorRepository.findAll();
	}

	@Override
	public List<AutorTestimonio> getAutoresDisponibles() {
		return (List<AutorTestimonio>)autorRepository.AutorTestimonio();
	}

	@Override
	public void addAutorTest(AutorTestimonio autorTestimonio) {
		autorRepository.save(autorTestimonio);
	}

	@Override
	public AutorTestimonio findAutorById(long idAutor) {
		return autorRepository.findById(idAutor).orElse(null);
	}

	@Override
	public void eliminarAutorTestimonio(AutorTestimonio autorTestimonio) {
		autorTestimonio.setEstado(false);
		autorRepository.save(autorTestimonio);
	}

}
