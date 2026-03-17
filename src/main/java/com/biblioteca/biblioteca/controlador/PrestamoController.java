package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.controlador.dto.PrestamoRequest;
import com.biblioteca.biblioteca.modelo.PrestamoActivo;
import com.biblioteca.biblioteca.servicio.PrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    public PrestamoActivo prestar(@Valid @RequestBody PrestamoRequest request) {
        return prestamoService.prestarLibro(
                request.getSocioId(),
                request.getEjemplarId()
        );
    }

    @PutMapping("/devolver/{id}")
    public void devolver(@Valid @PathVariable Long id) {
        prestamoService.devolverLibro(id);
    }
}
