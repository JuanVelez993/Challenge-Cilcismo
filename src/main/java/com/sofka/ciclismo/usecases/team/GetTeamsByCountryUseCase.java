package com.sofka.ciclismo.usecases.team;

import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.mapper.TeamMapper;
import com.sofka.ciclismo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class GetTeamsByCountryUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDto> getTeamsByCountry (String country){
        return teamRepository.findByCountry(country).map(team -> teamMapper.fromTeamToTeamDTO(team))
                .switchIfEmpty(Mono.error(() -> new IllegalStateException("No hay equipos de ese pais en el sistema")));
    }
}
