package com.movimente.mov.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Serie;
import com.movimente.mov.api.repository.SerieRepository;

@Service
public class SerieService {
	
	@Autowired
	private SerieRepository serieRepository;
	
	public List<Serie> buscarSerie() {
		return serieRepository.findAll();
	}

	public Serie salvarSerie(Serie serie) {
		Serie serieSalva = serieRepository.save(serie);
		return serieSalva;
	}

}


