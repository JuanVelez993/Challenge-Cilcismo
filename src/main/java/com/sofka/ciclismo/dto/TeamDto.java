package com.sofka.ciclismo.dto;

import com.sofka.ciclismo.collections.Cyclist;
import lombok.Data;

import java.util.List;

@Data
public class TeamDto {
    private String teamId;
    private String teamName;
    private String country;
    private List<Cyclist> cyclists;
}
