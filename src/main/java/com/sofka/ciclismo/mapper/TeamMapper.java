package com.sofka.ciclismo.mapper;

import com.sofka.ciclismo.collections.Team;
import com.sofka.ciclismo.collections.Team;
import com.sofka.ciclismo.collections.Team;
import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.dto.TeamDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamMapper {
    private final ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TeamDto fromTeamToTeamDTO(Team team){
        return modelMapper.map(team, TeamDto.class);
    }
    public Team fromTeamDTOToTeam(TeamDto teamDto){
        return modelMapper.map(teamDto, Team.class);
    }
}
