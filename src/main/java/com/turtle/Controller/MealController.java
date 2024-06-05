package com.turtle.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.turtle.Database.Meal.Meal;
import com.turtle.Database.User.Users;
import com.turtle.Service.MealService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/create")
    public Mono<Meal> create(Meal meal){
        return mealService.saveMeal(meal);
    }

    @GetMapping("/fetch")
    public Flux<Meal> fetch(Users user){
        return mealService.getMealsByUser(user.getUserID());
    }

}
