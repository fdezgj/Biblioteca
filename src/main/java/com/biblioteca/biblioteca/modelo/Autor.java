package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "El nombre es obligatorio")
    private String nombreCompleto;

    private String paisOrigen;

    //@ManyToMany(mappedBy = "autores")
    //private List<LibroConceptual> libros;

}
