package com.movimente.mov.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.event.RecursoCriadoEvent;
import com.movimente.mov.api.model.Exercicio;
import com.movimente.mov.api.service.ExercicioService;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
	@Autowired
    private ExercicioService exercicioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
    public ResponseEntity<?> getExercicios() {
        List<Exercicio> exercicio = exercicioService.buscarExercicios();
        return !exercicio.isEmpty() ? ResponseEntity.ok(exercicio) : ResponseEntity.notFound().build();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Exercicio> criarExercicios(@Valid @RequestBody Exercicio exercicio, HttpServletResponse response) {
		Exercicio exerciciosSalvo = exercicioService.insereExercicios(exercicio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, exerciciosSalvo.getCod()));	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exerciciosSalvo);
	}

}
