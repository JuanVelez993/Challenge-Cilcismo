package com.sofka.ciclismo.routes.team;

import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.usecases.team.UpdateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateTeamRoute {
    @Bean
    public RouterFunction<ServerResponse> updateTeam(UpdateTeamUseCase updateTeamUseCase) {
        return route(PUT("/api/v1/updateTeam").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDto.class)
                        .flatMap(updateTeamUseCase::updateTeam)
                        .flatMap(teamDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDto)));
    }
}
