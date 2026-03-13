package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.LibroConceptual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<LibroConceptual, String> {

    List<LibroConceptual> findByGenero(String genero);

    List<LibroConceptual> findByTituloObraContaining(String titulo);

}
