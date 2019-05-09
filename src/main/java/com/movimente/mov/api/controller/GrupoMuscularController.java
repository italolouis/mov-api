package com.movimente.mov.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.GrupoMuscular;
import com.movimente.mov.api.repository.GrupoMuscularRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoMuscularController {
	
	@Autowired
	private GrupoMuscularRepository grupoMuscularRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<GrupoMuscular> grupoMuscular = grupoMuscularRepository.findAll();
		return !grupoMuscular.isEmpty() ? ResponseEntity.ok(grupoMuscular) : ResponseEntity.notFound().build();
	}
	
}
