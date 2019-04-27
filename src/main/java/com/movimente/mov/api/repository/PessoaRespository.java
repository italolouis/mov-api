package com.movimente.mov.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.movimente.mov.api.model.Pessoa;

public interface PessoaRespository extends JpaRepository<Pessoa, Long>{
	public Pessoa findByEmail(String email);

}
