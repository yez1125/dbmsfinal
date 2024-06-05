package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.Food.Food;
import com.turtle.Service.FoodService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/create")
    public Mono<Food> createData(Food food){
        return foodService.saveFood(food);
    }

    @GetMapping("/fetch")
    public Flux<Food> getAllData(){
        return foodService.getFood();
    }
    
    @GetMapping("/fetchByName")
    public Flux<Food> getByName(Food food){
        return foodService.getFoodByName(food.getName()).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Food not found")));
    }
}
