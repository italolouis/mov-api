package com.movimente.mov.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.model.TipoExercicio;
import com.movimente.mov.api.repository.TipoExercicioRepository;
import com.movimente.mov.api.service.CategoriaService;
import com.movimente.mov.api.service.TipoExercicioService;

@RestController
@RequestMapping("/tipoExercicios")
public class TipoExercicioController {
	
	@Autowired
	private TipoExercicioRepository tipoExercicioRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private TipoExercicioService exercicioController;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<TipoExercicio> tipoExercicio = tipoExercicioRepository.findAll();
		return !tipoExercicio.isEmpty() ? ResponseEntity.ok(tipoExercicio) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{cod}")
    public ResponseEntity<?> buscarExercicioCategoria(@PathVariable Long cod) {
       Categoria categoria = categoriaService.buscarCategoriaId(cod);
       List<TipoExercicio> tipoExercicios = exercicioController.buscarExercicios(categoria);
       return !tipoExercicios.isEmpty() ? ResponseEntity.ok(tipoExercicios) : ResponseEntity.notFound().build();
    }
  
	
}
