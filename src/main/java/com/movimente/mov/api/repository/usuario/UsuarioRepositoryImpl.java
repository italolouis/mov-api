package com.movimente.mov.api.repository.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.model.Usuario_;
import com.movimente.mov.api.repository.filter.UsuarioFilter;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Usuario filtrar(UsuarioFilter usuarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);
		
		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Usuario> query = manager.createQuery(criteria);
		return query.getSingleResult();
	}	
	
	private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder,
			Root<Usuario> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(usuarioFilter.getEmail()) && !StringUtils.isEmpty(usuarioFilter.getSenha())) {
			predicates.add(builder.equal(
					builder.lower(root.get(Usuario_.email)), usuarioFilter.getEmail().toLowerCase()));
			
			predicates.add(builder.equal(
					builder.lower(root.get(Usuario_.senha)), usuarioFilter.getSenha().toLowerCase()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	

}
