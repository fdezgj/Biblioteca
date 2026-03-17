package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "libros")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LibroConceptual {

    @Id
    @NotBlank(message = "El ISBN es obligatorio")
    private String isbn;

    @Column(nullable = false)
    @NotBlank(message = "El título es obligatorio")
    private String tituloObra;

    @Min(value = 0, message = "El año no puede ser negativo")
    private int anioPublicacion;

    @Column(nullable = false)
    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_isbn"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

}
