package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.EjemplarLibro;
import com.biblioteca.biblioteca.repositorio.EjemplarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EjemplarService {

    private final EjemplarRepository ejemplarRepository;

    public EjemplarLibro guardar(EjemplarLibro ejemplar) {
        return ejemplarRepository.save(ejemplar);
    }

    public List<EjemplarLibro> disponibles() {
        return ejemplarRepository.findByPrestado(false);
    }

}