package com.movimente.mov.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Exercicio;
import com.movimente.mov.api.repository.ExercicioRepository;

@Service
public class ExercicioService {

	@Autowired
	private ExercicioRepository exercicioRepository;

	public List<Exercicio> buscarExercicios() {
		return exercicioRepository.findAll();
	}

	public Exercicio insereExercicios(Exercicio exercicio) {
		Exercicio exerciciosSalvo = exercicioRepository.save(exercicio);
		return exerciciosSalvo;
	}
	

}
