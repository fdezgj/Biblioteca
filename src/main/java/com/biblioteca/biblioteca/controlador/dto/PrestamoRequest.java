package com.biblioteca.biblioteca.controlador.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrestamoRequest {

    @NotNull(message = "El socioId es obligatorio")
    private Long socioId;

    @NotNull(message = "El ejemplarId es obligatorio")
    private Long ejemplarId;

}
