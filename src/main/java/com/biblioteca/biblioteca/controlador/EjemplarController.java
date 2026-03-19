package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.EjemplarLibro;
import com.biblioteca.biblioteca.servicio.EjemplarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")
@RequiredArgsConstructor
@Tag(name = "Ejemplares")
public class EjemplarController {

    private final EjemplarService ejemplarService;

    @PostMapping
    public EjemplarLibro crear(@RequestBody EjemplarLibro ejemplar) {
        return ejemplarService.guardar(ejemplar);
    }

    @GetMapping("/disponibles")
    public List<EjemplarLibro> disponibles() {
        return ejemplarService.disponibles();
    }
}
