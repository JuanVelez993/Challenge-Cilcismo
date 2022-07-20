package com.sofka.ciclismo.usecases.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.mapper.CyclistMapper;
import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
@AllArgsConstructor
public class GetCyclistByTeamUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;


    public Flux<CyclistDto> getCyclistByTeamId (String teamId){
        return cyclistRepository.findByTeamId(teamId).map(cyclist -> cyclistMapper.fromCyclistToCyclistDTO(cyclist))
                .switchIfEmpty(Mono.error(() -> new IllegalStateException("No hay ciclistas en ese equipo en el sistema")));
    }
}
