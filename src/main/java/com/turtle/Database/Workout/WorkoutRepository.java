package com.turtle.Database.Workout;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;




@Repository
public interface WorkoutRepository  extends ReactiveMongoRepository<Workout,String>{
   Flux<Workout> findWorkoutByUserID(String user);
}
