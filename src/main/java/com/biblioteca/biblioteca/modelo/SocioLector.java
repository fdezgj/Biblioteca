package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
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

    private String dni;

    @Column(nullable = false)
    private String nombreSocio;

    private boolean penalizado;

}
