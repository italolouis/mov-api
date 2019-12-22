package com.movimente.mov.api.controller;

import java.util.List;

import com.movimente.mov.api.event.RecursoCriadoEvent;
import com.movimente.mov.api.model.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.model.TipoExercicio;
import com.movimente.mov.api.repository.TipoExercicioRepository;
import com.movimente.mov.api.service.CategoriaService;
import com.movimente.mov.api.service.TipoExercicioService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoExercicio> criarTreino(@Valid @RequestBody TipoExercicio tipoExercicio, HttpServletResponse response) {
		TipoExercicio tipoExercicioSalvo = exercicioController.insereExercicios(tipoExercicio);;
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoExercicioSalvo );
	}
  
	
}
