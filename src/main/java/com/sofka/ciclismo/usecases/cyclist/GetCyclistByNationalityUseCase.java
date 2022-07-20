package com.sofka.ciclismo.usecases.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.mapper.CyclistMapper;
import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetCyclistByNationalityUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;


    public Flux<CyclistDto> getCyclistsByNationality (String nationality){
        return cyclistRepository.findByNationality(nationality).map(cyclist -> cyclistMapper.fromCyclistToCyclistDTO(cyclist))
                .switchIfEmpty(Mono.error(() -> new IllegalStateException("No hay ciclistas con esa nacionalidad en el sistema")));
    }

}
