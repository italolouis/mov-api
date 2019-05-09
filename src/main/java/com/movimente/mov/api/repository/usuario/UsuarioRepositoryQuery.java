package com.movimente.mov.api.repository.usuario;

import com.movimente.mov.api.model.Usuario;
import com.movimente.mov.api.repository.filter.UsuarioFilter;

public interface UsuarioRepositoryQuery {
	public Usuario filtrar(UsuarioFilter usuarioFilter);

}
