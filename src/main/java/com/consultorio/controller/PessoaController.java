package com.consultorio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.model.Pessoa;
import com.consultorio.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:4200") 
public class PessoaController {

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

  @PutMapping("/{id}")
public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
    return repository.findById(id)
        .map(pessoa -> {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setIdade(pessoaAtualizada.getIdade());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            Pessoa salvo = repository.save(pessoa);
            return ResponseEntity.ok(salvo);
        })
        .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
    return repository.findById(id)
        .map(pessoa -> {
            repository.delete(pessoa);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
}

}