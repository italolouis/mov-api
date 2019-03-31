package com.movimente.mov.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.repository.UsuarioRespository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRespository usuarioRespository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Usuario> usuarios = usuarioRespository.findAll();
		return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRespository.save(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codusu}")
				.buildAndExpand(usuarioSalvo.getCodusu()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(usuarioSalvo);
	}
	
	@GetMapping("/{codusu}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codusu) {
		Usuario usuario = usuarioRespository.findOne(codusu);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

}
