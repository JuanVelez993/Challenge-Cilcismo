package com.sofka.ciclismo.routes.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.usecases.cyclist.GetCyclistByNationalityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistByNationalityRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistByNationality(GetCyclistByNationalityUseCase getCyclistByNationalityUseCase){
        return route(GET("/api/v1/getByNationality/{nationality}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getCyclistByNationalityUseCase.getCyclistsByNationality(request.pathVariable("nationality")),
                                CyclistDto.class)));
    }
}
