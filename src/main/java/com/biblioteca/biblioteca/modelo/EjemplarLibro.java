package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "El código de barras es obligatorio")
    private String codigoBarrasTag;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private EstadoEjemplar estadoConservacion;

    private boolean prestado;

    @ManyToOne
    @JoinColumn(name = "libro_isbn")
    private LibroConceptual libro;

}
