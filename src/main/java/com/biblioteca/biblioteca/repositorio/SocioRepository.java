package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.SocioLector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocioRepository extends JpaRepository<SocioLector, Long> {

    Optional<SocioLector> findByDni(String dni);

}
