package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
}
