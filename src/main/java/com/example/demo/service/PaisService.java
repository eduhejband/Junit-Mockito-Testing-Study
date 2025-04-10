package com.example.demo.service;

import com.example.demo.model.Pais;
import com.example.demo.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais salvar(Pais pais) {
        return paisRepository.save(pais);
    }

    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    public Optional<Pais> buscarPorId(Long id) {
        return paisRepository.findById(id);
    }

    public void deletar(Long id) {
        paisRepository.deleteById(id);
    }
}
