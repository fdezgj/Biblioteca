package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.LibroConceptual;
import com.biblioteca.biblioteca.servicio.LibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    public LibroConceptual crear(@Valid @RequestBody LibroConceptual libro) {
        return libroService.guardar(libro);
    }

    @GetMapping
    public List<LibroConceptual> listar() {
        return libroService.listar();
    }

    @GetMapping("/genero/{genero}")
    public List<LibroConceptual> porGenero(@PathVariable String genero) {
        return libroService.buscarPorGenero(genero);
    }
}
