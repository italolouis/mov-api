package com.movimente.mov.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movimente.mov.api.model.Categoria;
import com.movimente.mov.api.service.CategoriaService;

@RestController
@RequestMapping(path = "/categorias/{parentid}/subcategorias")
public class SubCategoriasController {
	@Autowired
    private CategoriaService categoryService;
    
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> retrieveAllSubcategorias(@PathVariable Long parentid) {
        Categoria categoria = categoryService.buscarCategoriaId(parentid);
        final Set<Categoria> subcategories = categoria.getSubCategorias();
        return subcategories != null ? ResponseEntity.ok(subcategories) : ResponseEntity.notFound().build();
    }

}
