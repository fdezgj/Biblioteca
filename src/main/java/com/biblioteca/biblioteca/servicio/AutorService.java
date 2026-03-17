package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.repositorio.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

}
