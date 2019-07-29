package com.movimente.mov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimente.mov.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	String GET_RECURSIVELY_ALL_SUBCATEGORIES_SQL = "WITH RECURSIVE ALL_SUBCATEGORIES(COD, PARENTID) AS (select c.cod, c.parentid from categoria c where c.parentid is null union all select c.cod, c.parentid from ALL_SUBCATEGORIES inner join categoria c on ALL_SUBCATEGORIES.cod = c.parentid) select cod, parentid from ALL_SUBCATEGORIES";
}
