package com.example.demo.service;



import com.example.demo.model.Pais;
import com.example.demo.repository.PaisRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaisServiceTest {

    private final PaisRepository repository = mock(PaisRepository.class);
    private final PaisService service = new PaisService(repository);

    @Test
    void deveSalvarPais() {
        Pais pais = new Pais(null, "Brasil");
        Pais salvo = new Pais(1L, "Brasil");

        when(repository.save(pais)).thenReturn(salvo);

        Pais result = service.salvar(pais);

        assertEquals(1L, result.getId());
        assertEquals("Brasil", result.getNome());
    }

    @Test
    void deveListarPaises() {
        when(repository.findAll()).thenReturn(List.of(new Pais(1L, "Brasil")));

        List<Pais> lista = service.listarTodos();

        assertEquals(1, lista.size());
        assertEquals("Brasil", lista.get(0).getNome());
    }

    @Test
    void deveBuscarPorId() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Pais(1L, "Argentina")));

        Optional<Pais> encontrado = service.buscarPorId(1L);

        assertTrue(encontrado.isPresent());
        assertEquals("Argentina", encontrado.get().getNome());
    }

    @Test
    void deveDeletarPorId() {
        doNothing().when(repository).deleteById(1L);

        service.deletar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
