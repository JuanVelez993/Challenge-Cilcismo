package com.sofka.ciclismo.routes.team;

import com.sofka.ciclismo.usecases.team.DeleteTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTeamRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteTeam(DeleteTeamUseCase deleteTeamUseCase) {
        return route(DELETE("/api/v1/deleteTeam/{teamId}"),
                request -> deleteTeamUseCase.deleteTeam(request.pathVariable("teamId"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
