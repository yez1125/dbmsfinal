package com.turtle.Database.Goal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface GoalRepository extends ReactiveMongoRepository<Goal,String> {
    Mono<Goal> findGoalByUserID(String user);
}
