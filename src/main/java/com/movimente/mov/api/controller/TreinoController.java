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
import com.movimente.mov.api.model.Treino;
import com.movimente.mov.api.service.TreinoService;

@RestController
@RequestMapping("/treino")
public class TreinoController {
	@Autowired
    private TreinoService treinoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
    public ResponseEntity<?> buscarTreino() {
        List<Treino> treino = treinoService.buscarTreino();
        return !treino.isEmpty() ? ResponseEntity.ok(treino) : ResponseEntity.notFound().build();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Treino> criarTreino(@Valid @RequestBody Treino treino, HttpServletResponse response) {
		Treino treinoSalvo = treinoService.insereTreino(treino);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, treinoSalvo.getCod()));	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(treinoSalvo);
	}


}
