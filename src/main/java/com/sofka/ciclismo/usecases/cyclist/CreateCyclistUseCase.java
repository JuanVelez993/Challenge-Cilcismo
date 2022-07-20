package com.sofka.ciclismo.usecases.cyclist;


import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.mapper.CyclistMapper;
import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateCyclistUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Mono<CyclistDto> createCyclist(CyclistDto cyclistDto){
        return cyclistRepository.save(cyclistMapper.fromCyclistDTOToCyclist(cyclistDto)).map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
