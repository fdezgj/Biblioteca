package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "socios")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SocioLector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombreSocio;

    private boolean penalizado;

}
