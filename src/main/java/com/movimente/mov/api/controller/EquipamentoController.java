package com.movimente.mov.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.Equipamento;
import com.movimente.mov.api.repository.EquipamentoRepository;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Equipamento> equipamento = equipamentoRepository.findAll();
		return !equipamento.isEmpty() ? ResponseEntity.ok(equipamento) : ResponseEntity.notFound().build();
	}
	
}
