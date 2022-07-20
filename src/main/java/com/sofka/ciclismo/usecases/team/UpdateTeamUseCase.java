package com.sofka.ciclismo.usecases.team;

import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.mapper.TeamMapper;
import com.sofka.ciclismo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Validated
public class UpdateTeamUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Mono<TeamDto> updateTeam(TeamDto teamDto) {
        return teamRepository.save(teamMapper.fromTeamDTOToTeam(teamDto)).map(teamMapper::fromTeamToTeamDTO);
    }
}
