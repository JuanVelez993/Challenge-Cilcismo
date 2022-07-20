package com.sofka.ciclismo.usecases.cyclist;

import com.sofka.ciclismo.repository.CyclistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Void> deleteCyclist(String tagNumber) {
        return cyclistRepository.findById(tagNumber).switchIfEmpty(Mono.error(new IllegalStateException("El ciclista no existe en el sistema")))
                .flatMap(cyclist -> cyclistRepository.deleteById(cyclist.getTagNumber()));
    }
}
