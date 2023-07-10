package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Testimonio;

public interface ITestimonioService {

	List <Testimonio> getList();
	
	void guardar(Testimonio testimonio);
	
	Testimonio getBy(long idTestimonio);
	
	void modificar(Testimonio testimonio);
	
	void eliminar(Testimonio testimonio);
	
	Testimonio getTestimonio();

	List<Testimonio> getLista();
}
