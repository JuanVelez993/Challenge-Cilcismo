package com.sofka.ciclismo.dto;

import com.sofka.ciclismo.collections.Cyclist;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TeamDto {
    @Size(max=3)
    private String teamId;
    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String teamName;
    @NotBlank(message = "El pais del equipo es obligatorio")
    private String country;
    @Size(max=8)
    private List<CyclistDto> cyclists;
}
