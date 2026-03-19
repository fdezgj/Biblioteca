package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.LibroConceptual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<LibroConceptual, String> {

    List<LibroConceptual> findByGenero(String genero);

    List<LibroConceptual> findByTituloObraContaining(String titulo);

}
