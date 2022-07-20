package com.sofka.ciclismo.mapper;

import com.sofka.ciclismo.collections.Cyclist;
import com.sofka.ciclismo.dto.CyclistDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CyclistMapper {
    private final ModelMapper modelMapper;

    public CyclistMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CyclistDto fromCyclistToCyclistDTO(Cyclist cyclist){
        return modelMapper.map(cyclist, CyclistDto.class);
    }

    public Cyclist fromCyclistDTOToCyclist(CyclistDto cyclistDto){
        return modelMapper.map(cyclistDto, Cyclist.class);
    }


}
