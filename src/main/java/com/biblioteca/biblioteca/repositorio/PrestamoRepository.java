package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.PrestamoActivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoActivo, Long> {

    List<PrestamoActivo> findBySocioId(Long socioId);

}
