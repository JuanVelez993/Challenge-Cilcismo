package com.sofka.ciclismo.routes.team;


import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.usecases.team.CreateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateTeamRoute {


    @Bean
    public RouterFunction<ServerResponse> createTeam(CreateTeamUseCase createTeamUseCase ) {
        return route(POST("/api/v1/createTeam").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDto.class)
                        .flatMap(createTeamUseCase::createTeam)
                        .flatMap(teamDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDto)));
    }
}
