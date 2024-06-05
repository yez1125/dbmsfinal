package com.turtle.Database.Exercise;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;



@Repository
public interface ExerciseRepository extends ReactiveMongoRepository<Exercise,String>{
    Mono<Exercise> findByName(String name);
}
