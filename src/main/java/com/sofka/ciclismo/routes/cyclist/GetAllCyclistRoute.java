package com.sofka.ciclismo.routes.cyclist;


import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.usecases.cyclist.GetAllCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllCyclists(GetAllCyclistUseCase getAllCyclistUseCase) {
        return route(GET("/api/v1/getAllCyclists"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllCyclistUseCase.getAllCyclists(), CyclistDto.class)));

    }
}
