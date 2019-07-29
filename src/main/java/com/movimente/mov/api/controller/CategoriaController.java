package com.movimente.mov.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
    private CategoriaService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> retrieveAllCategories() {
        List<Categoria> categorias = categoryService.buscarCategorias();

        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build();
    }
    
    @RequestMapping(path = "/{cod}", method = RequestMethod.GET)
    public ResponseEntity<?> retrieveCategoria(@PathVariable Long cod) {
       Categoria categoria = categoryService.buscarCategoriaId(cod);

       return categoria != null  ?ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}
