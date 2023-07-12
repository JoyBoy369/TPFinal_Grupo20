package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.AutorTestimonio;

@Repository
public interface AutorRepository extends CrudRepository<AutorTestimonio, Long>{
	
	@Query(value="SELECT a FROM Autor a WHERE a.estado=true")
	public List<AutorTestimonio> AutorTestimonio();
		
}
