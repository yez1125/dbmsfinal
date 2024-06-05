package com.turtle.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Meal.Meal;
import com.turtle.Database.Meal.MealRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MealService {
    @Autowired
    private  MealRepository mealRepository;

    public Mono<Meal> saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void deleteMeal(String id) {
        mealRepository.deleteById(id);
    }

    public Flux<Meal> getMealsByUser(String userID){
        return mealRepository.findMealByUser(userID);
    }
}
