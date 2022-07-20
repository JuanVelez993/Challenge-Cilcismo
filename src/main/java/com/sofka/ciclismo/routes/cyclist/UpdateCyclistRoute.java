package com.sofka.ciclismo.routes.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.usecases.cyclist.UpdateCyclistUseCase;
import com.sofka.ciclismo.usecases.cyclist.UpdateCyclistUseCase;
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
public class UpdateCyclistRoute {
    @Bean
    public RouterFunction<ServerResponse> updateCyclist(UpdateCyclistUseCase updateCyclistUseCase) {
        return route(PUT("/api/v1/updateCyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDto.class)
                        .flatMap(updateCyclistUseCase::updateCyclist)
                        .flatMap(cyclistDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDto)));
    }
}
