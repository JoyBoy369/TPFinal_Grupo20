package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;



@Service("usuarioServiceImp")
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;
	
	@Override
	public List<Usuario> getLista(){
		
		
		return usuarioRepository.findByEstado(true);
	}
	
	
	@Override
	public List<Usuario> getBuscar(Long idbuscado){
		
		if(idbuscado != null)
			return usuarioRepository.findByCodigo(idbuscado);
		return usuarioRepository.findByEstado(true);
	}
	
	
	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}
	@Override
	public Usuario getby(Long id) {
		
		return usuarioRepository.findById(id).get();
	}
	
	@Override
	public void modificar(Usuario usuario) {
		
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void eliminar (Usuario usuarioEncontrado) {
		
		usuarioEncontrado.setEstado(false);
		usuarioRepository.save(usuarioEncontrado);
	}
	
	@Override
	public Usuario getUsuario() {
		return usuario;
	}
	

}
