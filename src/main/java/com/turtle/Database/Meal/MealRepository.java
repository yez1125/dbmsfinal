package com.turtle.Database.Meal;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


@Repository
public interface MealRepository extends ReactiveMongoRepository<Meal,String>{
   Flux<Meal> findMealByUser(String userID);
}
