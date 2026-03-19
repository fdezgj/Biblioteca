package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.EjemplarLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EjemplarRepository extends JpaRepository<EjemplarLibro, Long> {

    List<EjemplarLibro> findByPrestado(boolean prestado);

}
