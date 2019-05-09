package com.movimente.mov.api.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.event.RecursoCriadoEvent;
import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.repository.UsuarioRepository;
import com.movimente.mov.api.repository.filter.UsuarioFilter;
import com.movimente.mov.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Usuario login(UsuarioFilter usuarioFilter) {
		return usuarioRepository.filtrar(usuarioFilter);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodusu()));	
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
		
	}
	
	@GetMapping("/{codusu}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codusu) {
		Usuario usuario = usuarioRepository.findOne(codusu);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}
	

	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long codigo, @Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.atualizar(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
}
