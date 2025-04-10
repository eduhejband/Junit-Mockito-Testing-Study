package com.example.demo.controller;

import com.example.demo.model.Pais;
import com.example.demo.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisService service;

    public PaisController(PaisService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pais> criar(@RequestBody Pais pais) {
        return ResponseEntity.ok(service.salvar(pais));
    }

    @GetMapping
    public List<Pais> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
