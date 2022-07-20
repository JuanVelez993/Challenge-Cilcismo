package com.sofka.ciclismo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CyclistDto {
    @Size(max=3)
    private String tagNumber;
    @NotBlank(message = "El nombre del ciclista es obligatorio")
    private String name;
    @Size(max=3)
    private String teamId;
    @NotBlank(message = "La nacionalidad del ciclista es obligatorio")
    private String nationality;
}

