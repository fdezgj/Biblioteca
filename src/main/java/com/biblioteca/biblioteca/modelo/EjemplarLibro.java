package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ejemplares")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EjemplarLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoBarrasTag;

    @Enumerated(EnumType.STRING)
    private EstadoEjemplar estadoConservacion;

    private boolean prestado;

    @ManyToOne
    @JoinColumn(name = "libro_isbn")
    private LibroConceptual libro;

}
