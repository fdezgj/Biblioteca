package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.LibroConceptual;
import com.biblioteca.biblioteca.servicio.LibroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
@Tag(name = "Libros")
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

    @GetMapping("/{isbn}")
    public LibroConceptual obtener(@PathVariable String isbn) {
        return libroService.buscarPorId(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @PutMapping("/{isbn}")
    public LibroConceptual actualizar(@PathVariable String isbn,
                                      @Valid @RequestBody LibroConceptual libro) {

        LibroConceptual existente = libroService.buscarPorId(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        existente.setTituloObra(libro.getTituloObra());
        existente.setGenero(libro.getGenero());
        existente.setAnioPublicacion(libro.getAnioPublicacion());

        return libroService.guardar(existente);
    }

    @DeleteMapping("/{isbn}")
    public void eliminar(@PathVariable String isbn) {
        libroService.eliminar(isbn);
    }
}
