package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.Autor;
import com.biblioteca.biblioteca.servicio.AutorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
@Tag(name = "Autores")
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public Autor crear(@Valid @RequestBody Autor autor) {
        return autorService.guardar(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return autorService.listar();
    }
}
