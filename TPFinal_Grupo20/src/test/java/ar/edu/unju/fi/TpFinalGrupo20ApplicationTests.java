package ar.edu.unju.fi;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

@SpringBootTest
class TpFinalGrupo20ApplicationTests {

	
	@Autowired
	IUsuarioService usuarioService;
	
	Usuario usuario;
	
	
	
	@Test
	void contextLoads() {
		
		Usuario usuario = new Usuario();
	
		usuario.setApellido("Zambrano");
		usuario.setCorreo("correo23@gmail.com");
		usuario.setFecha(LocalDate.of(2002, 03, 17));
		usuario.setTelefono("3885812678");
		usuario.setGenero("Femenino");
		usuario.setAltura(1.78);
		usuario.setNombre("Coconuts");
		usuario.setEstado(true);
		usuario.setDni("48729118");
		
		usuarioService.guardar(usuario);
		
		System.out.println(usuario.toString());
		
		
	}

}
