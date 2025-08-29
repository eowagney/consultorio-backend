package com.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.model.Pessoa;
import com.consultorio.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:4200") 
public class PessoaController {

     @Autowired
    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
