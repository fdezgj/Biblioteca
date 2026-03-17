package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.*;
import com.biblioteca.biblioteca.repositorio.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final SocioRepository socioRepository;
    private final EjemplarRepository ejemplarRepository;

    @Transactional
    public PrestamoActivo prestarLibro(Long socioId, Long ejemplarId) {

        // 1. Buscar socio
        SocioLector socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        // 2. Buscar ejemplar
        EjemplarLibro ejemplar = ejemplarRepository.findById(ejemplarId)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado"));

        // 3. Validaciones
        if (ejemplar.isPrestado()) {
            throw new RuntimeException("El ejemplar ya está prestado");
        }

        if (socio.isPenalizado()) {
            throw new RuntimeException("El socio está penalizado");
        }

        // 4. Crear préstamo
        PrestamoActivo prestamo = PrestamoActivo.builder()
                .fechaRetiro(LocalDate.now())
                .fechaVencimiento(LocalDate.now().plusDays(15))
                .socio(socio)
                .ejemplar(ejemplar)
                .build();

        // 5. Marcar ejemplar como prestado
        ejemplar.setPrestado(true);
        ejemplarRepository.save(ejemplar);

        // 6. Guardar préstamo
        return prestamoRepository.save(prestamo);
    }
    @Transactional
    public void devolverLibro(Long prestamoId) {

        PrestamoActivo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        // marcar devolución
        prestamo.setFechaEntregaReal(LocalDate.now());

        // liberar ejemplar
        EjemplarLibro ejemplar = prestamo.getEjemplar();
        ejemplar.setPrestado(false);
        ejemplarRepository.save(ejemplar);

        // penalización si hay retraso
        if (prestamo.getFechaEntregaReal().isAfter(prestamo.getFechaVencimiento())) {
            SocioLector socio = prestamo.getSocio();
            socio.setPenalizado(true);
            socioRepository.save(socio);
        }

        prestamoRepository.save(prestamo);
    }
}
