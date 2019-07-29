package com.movimente.mov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.repository.usuario.UsuarioRepositoryQuery;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {

}
