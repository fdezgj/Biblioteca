package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "autores")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCompleto;

    private String paisOrigen;

    @ManyToMany(mappedBy = "autores")
    private List<LibroConceptual> libros;

}
