package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;




public interface IUsuarioService {

	
	
	List<Usuario> getLista();
	
	public List<Usuario> getBuscar(Long idbuscado);
			
	
	void guardar(Usuario usuario);
	
	Usuario getby(Long id);
	
	void modificar(Usuario usuario);
	
	void eliminar (Usuario usuario);
	
	Usuario getUsuario();
	
}


