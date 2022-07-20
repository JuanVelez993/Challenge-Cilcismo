package com.sofka.ciclismo.usecases.team;

import com.sofka.ciclismo.mapper.TeamMapper;
import com.sofka.ciclismo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class DeleteTeamUseCase {
    private final TeamRepository teamRepository;

    public Mono<Void> deleteTeam(String teamId) {
        return teamRepository.findById(teamId).switchIfEmpty(Mono.error(new IllegalStateException("El equipo no existe en el sistema")))
                .flatMap(team -> teamRepository.deleteById(team.getTeamId()));
    }
}
