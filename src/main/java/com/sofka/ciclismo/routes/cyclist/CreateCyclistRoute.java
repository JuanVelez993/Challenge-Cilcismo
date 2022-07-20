package com.sofka.ciclismo.routes.cyclist;


import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.usecases.cyclist.CreateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> createCyclist(CreateCyclistUseCase createCyclistUseCase) {
        return route(POST("/api/v1/createCyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDto.class)
                        .flatMap(createCyclistUseCase::createCyclist)
                        .flatMap(cyclistDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDto)));
    }
}
