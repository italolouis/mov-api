package com.movimente.mov.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Treino;
import com.movimente.mov.api.repository.TreinoRepository;

@Service
public class TreinoService {
	@Autowired
	private TreinoRepository treinoRepository;
	
	public List<Treino> buscarTreino() {
		return treinoRepository.findAll();
	}
	
	public Treino insereTreino(Treino treino) {
		Treino treinoSalvo = treinoRepository.save(treino);
		return treinoSalvo;
	}
	

}
