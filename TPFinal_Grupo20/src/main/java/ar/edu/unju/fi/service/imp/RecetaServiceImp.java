package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

@Service
public class RecetaServiceImp implements IRecetaService {

    @Autowired
    private IRecetaRepository recetaRepository;

    @Override
    public List<Receta> getRecetas() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta getRecetaById(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarReceta(Receta receta) {
        recetaRepository.save(receta);
    }

    @Override
    public void modificarReceta(Receta receta) {
        recetaRepository.save(receta);
    }

    @Override
    public void deleteReceta(Receta receta) {
        recetaRepository.delete(receta);
    }

}

