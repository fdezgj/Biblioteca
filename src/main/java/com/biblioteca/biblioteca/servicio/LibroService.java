package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.LibroConceptual;
import com.biblioteca.biblioteca.repositorio.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroConceptual guardar(LibroConceptual libro) {
        return libroRepository.save(libro);
    }

    public List<LibroConceptual> listar() {
        return libroRepository.findAll();
    }

    public List<LibroConceptual> buscarPorGenero(String genero) {
        return libroRepository.findByGenero(genero);
    }
}
