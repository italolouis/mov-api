package com.movimente.mov.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.event.RecursoCriadoEvent;
import com.movimente.mov.api.model.Serie;
import com.movimente.mov.api.service.SerieService;

@RestController
@RequestMapping("/serie")
public class SerieController {
	@Autowired
    private SerieService serieService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
    public ResponseEntity<?> buscarSeries() {
        List<Serie> series = serieService.buscarSerie();
        return !series.isEmpty() ? ResponseEntity.ok(series) : ResponseEntity.notFound().build();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Serie> criarSerie(@Valid @RequestBody Serie serie, HttpServletResponse response) {
		Serie serieSalva = serieService.salvarSerie(serie);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, serieSalva.getCod()));	
		return ResponseEntity.status(HttpStatus.CREATED).body(serieSalva);
		
	}

}
