package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public List<Usuario> findByEstado(boolean estado);

	
	
	@Query("SELECT usu FROM Usuario usu WHERE usu.id LIKE %?1%")
	public List<Usuario> findByCodigo(Long id);
	
}
