package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collections.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
    Flux<Cyclist> findByNationality(String nationality);
    Flux<Cyclist> findByTeamId(String teamId);


}
