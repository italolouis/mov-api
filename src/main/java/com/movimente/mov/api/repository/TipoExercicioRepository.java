package com.movimente.mov.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movimente.mov.api.model.TipoExercicio;

@Repository
public interface TipoExercicioRepository extends JpaRepository<TipoExercicio, Long>{
	
	String GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL = "select p.* from exercicio p inner join exercicio_categoria pc on p.cod = pc.exerciciocod where (pc.categoriacod = ?1 or pc.categoriacod in (select ac.cod from (" + CategoriaRepository.GET_RECURSIVELY_ALL_SUBCATEGORIES_SQL + ") ac where ac.parentid = ? 1)) ";
	String COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL = "select count(1) from (" + GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL + ")";

	
    @Query(value = GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL, countQuery = COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL, nativeQuery = true)
    List<TipoExercicio> findByAssociatedWithCategory(Long categoryId);
}
