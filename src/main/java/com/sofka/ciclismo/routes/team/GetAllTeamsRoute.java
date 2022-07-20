package com.sofka.ciclismo.routes.team;


import com.sofka.ciclismo.dto.TeamDto;
import com.sofka.ciclismo.usecases.team.GetAllTeamsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllTeamsRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllTeams(GetAllTeamsUseCase getAllTeamsUseCase) {
        return route(GET("/api/v1/getAllTeams"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllTeamsUseCase.getAllTeams(), TeamDto.class)));

    }
}
