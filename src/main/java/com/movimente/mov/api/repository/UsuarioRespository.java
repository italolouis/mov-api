package com.movimente.mov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimente.mov.api.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Long>{

}
