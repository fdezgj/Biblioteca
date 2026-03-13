package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PrestamoActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaRetiro;

    private LocalDate fechaVencimiento;

    private LocalDate fechaEntregaReal;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private SocioLector socio;

    @ManyToOne
    @JoinColumn(name = "ejemplar_id")
    private EjemplarLibro ejemplar;

}
