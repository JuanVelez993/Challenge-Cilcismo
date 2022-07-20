package com.sofka.ciclismo.usecases.team;

import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.mapper.TeamMapper;
import com.sofka.ciclismo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
public class GetAllTeamsUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDto> getAllTeams(){
        return teamRepository.findAll().map(teamMapper::fromTeamToTeamDTO);
    }
}
