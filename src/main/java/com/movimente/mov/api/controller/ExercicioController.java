package com.movimente.mov.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.Exercicio;
import com.movimente.mov.api.repository.ExercicioRepository;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Exercicio> exercicio = exercicioRepository.findAll();
		return !exercicio.isEmpty() ? ResponseEntity.ok(exercicio) : ResponseEntity.notFound().build();
	}
	
}
