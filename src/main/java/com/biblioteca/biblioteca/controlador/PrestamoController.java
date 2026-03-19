package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.controlador.dto.PrestamoRequest;
import com.biblioteca.biblioteca.modelo.PrestamoActivo;
import com.biblioteca.biblioteca.servicio.PrestamoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
@Tag(name = "Prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping("/socio/{id}")
    public List<PrestamoActivo> porSocio(@PathVariable Long id) {
        return prestamoService.buscarPorSocio(id);
    }

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
