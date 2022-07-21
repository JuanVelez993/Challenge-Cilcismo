package com.sofka.ciclismo.usecases.cyclist;

import com.sofka.ciclismo.dto.CyclistDto;
import com.sofka.ciclismo.mapper.CyclistMapper;
import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
public class UpdateCyclistUseCase {
    private CyclistRepository cyclistRepository;
    private CyclistMapper cyclistMapper;

    public Mono<CyclistDto> updateCyclist( @Valid CyclistDto cyclistDto) {
        return cyclistRepository.save(cyclistMapper.fromCyclistDTOToCyclist(cyclistDto)).map(cyclistMapper::fromCyclistToCyclistDTO);
    }
}
