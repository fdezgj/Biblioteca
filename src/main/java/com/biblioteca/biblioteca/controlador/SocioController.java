package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.SocioLector;
import com.biblioteca.biblioteca.servicio.SocioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/socios")
@RequiredArgsConstructor
@Tag(name = "Socios")
public class SocioController {

    private final SocioService socioService;

    @PostMapping
    public SocioLector crear(@Valid @RequestBody SocioLector socio) {
        return socioService.guardar(socio);
    }

    @GetMapping("/dni/{dni}")
    public Optional<SocioLector> buscar(@PathVariable String dni) {
        return socioService.buscarPorDni(dni);
    }
}
