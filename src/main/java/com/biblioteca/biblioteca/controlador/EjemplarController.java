package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.EjemplarLibro;
import com.biblioteca.biblioteca.servicio.EjemplarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")
@RequiredArgsConstructor
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
