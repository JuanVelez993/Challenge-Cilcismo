package com.sofka.ciclismo.usecases.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.mapper.CyclistMapper;
import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllCyclistUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDto> getAllCyclists(){
        return cyclistRepository.findAll().map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
