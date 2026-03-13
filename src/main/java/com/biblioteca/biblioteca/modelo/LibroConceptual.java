package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
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
    private String isbn;

    @Column(nullable = false)
    private String tituloObra;

    private int anioPublicacion;

    private String genero;

    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_isbn"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

}
