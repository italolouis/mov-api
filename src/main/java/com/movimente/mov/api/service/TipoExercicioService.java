package com.movimente.mov.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.model.TipoExercicio;
import com.movimente.mov.api.repository.TipoExercicioRepository;

@Service
public class TipoExercicioService {
	@Autowired
	private TipoExercicioRepository exercicioService;
	
	
	public List<TipoExercicio> buscarExercicios(Categoria categoria) {
        return exercicioService.findByAssociatedWithCategory(categoria.getCod());
    }

	public TipoExercicio insereExercicios(TipoExercicio tipoExercicio) {
		return exercicioService.save(tipoExercicio);
	}
	
}
