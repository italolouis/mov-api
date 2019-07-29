package com.movimente.mov.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> buscarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria buscarCategoriaId(Long parentid) {
		return categoriaRepository.findOne(parentid);
	}

}
