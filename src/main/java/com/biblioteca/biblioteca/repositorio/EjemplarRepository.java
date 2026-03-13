package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.EjemplarLibro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjemplarRepository extends JpaRepository<EjemplarLibro, Long> {

    List<EjemplarLibro> findByPrestado(boolean prestado);

}
