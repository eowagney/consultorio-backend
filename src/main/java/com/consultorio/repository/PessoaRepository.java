package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import com.consultorio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa save(@RequestBody Pessoa pessoa);
}
