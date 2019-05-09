package com.movimente.mov.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscarUsuarioPeloCodigo(Long codigo) {
		Usuario pessoaSalva = usuarioRepository.findOne(codigo);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalvo = buscarUsuarioPeloCodigo(codigo);
		
		BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");
		return usuarioRepository.save(usuarioSalvo);
	}

}
