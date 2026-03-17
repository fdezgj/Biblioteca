package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.SocioLector;
import com.biblioteca.biblioteca.repositorio.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioLector guardar(SocioLector socio) {
        return socioRepository.save(socio);
    }

    public Optional<SocioLector> buscarPorDni(String dni) {
        return socioRepository.findByDni(dni);
    }

}
