package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.SocioLector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SocioRepository extends JpaRepository<SocioLector, Long> {

    Optional<SocioLector> findByDni(String dni);

}
