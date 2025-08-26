package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
