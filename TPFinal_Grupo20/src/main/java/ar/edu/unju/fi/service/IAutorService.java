package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.AutorTestimonio;

public interface IAutorService {
	
	public List<AutorTestimonio> getListAllAutores(); //Lista todos los autores
	
	public List<AutorTestimonio>getAutoresDisponibles(); //Obtine unicamente los autores que estan disponibles
	
	public void addAutorTest(AutorTestimonio autorTestimonio); // Modifica y Guarda un autor
	
	public AutorTestimonio findAutorById(long idAutor); //Busca un autor en base a su ID 
	
	void eliminarAutorTestimonio(AutorTestimonio autorTestimonio); //Borra un autor  
}
