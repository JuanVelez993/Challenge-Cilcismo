package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collections.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {

}
