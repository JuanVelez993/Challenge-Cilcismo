package com.sofka.ciclismo.routes.cyclist;

import com.sofka.ciclismo.usecases.cyclist.DeleteCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteCyclistRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteCyclist(DeleteCyclistUseCase deleteCyclistUseCase) {
        return route(DELETE("/api/v1/deleteCyclist/{cyclistId}"),
                request -> deleteCyclistUseCase.deleteCyclist(request.pathVariable("cyclistId"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
