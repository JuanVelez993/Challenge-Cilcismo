package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collections.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {
    Flux<Team> findByCountry(String country);
}
