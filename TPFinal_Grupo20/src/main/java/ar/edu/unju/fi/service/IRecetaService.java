package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {
    List<Receta> getRecetas();
    
   public Receta getRecetaById(Long id);
    
    public void agregarReceta(Receta receta);
   
    public void modificarReceta(Receta receta); 
    
    public void deleteReceta(Receta receta);
  
}

